package com.gfxgamerlab.shizukuplus.service

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gfxgamerlab.shizukuplus.ShizukuSettings
import com.gfxgamerlab.shizukuplus.adb.AdbStarter
import com.gfxgamerlab.shizukuplus.adb.SmartLocalTcpBridge
import com.gfxgamerlab.shizukuplus.receiver.ShizukuReceiverStarter
import com.gfxgamerlab.shizukuplus.utils.Diag
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import rikka.shizuku.Shizuku

object AutoHealNeuralWatchdog {

    private const val TAG = "AutoHealNeuralWatchdog"
    private const val MAX_RAPID_ATTEMPTS = 3
    private const val INITIAL_BACKOFF_MS = 2000L

    var isWatchdogActive by mutableStateOf(false)
        private set

    var isAutoHealing by mutableStateOf(false)
        private set

    var autoHealAttempts by mutableIntStateOf(0)
        private set

    var statusMessage by mutableStateOf("Neural Watchdog: Active & Monitoring")
        private set

    private var monitorJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    fun start(context: Context) {
        if (monitorJob?.isActive == true) return
        isWatchdogActive = true
        statusMessage = "Neural Watchdog: Active & Monitoring"

        monitorJob = scope.launch {
            var consecutiveFailures = 0
            while (isActive) {
                delay(2500L)

                val autoHealEnabled = ShizukuSettings.getAutoHealNeuralWatchdog()
                val normalWatchdogEnabled = ShizukuSettings.getWatchdog()
                if (!autoHealEnabled || normalWatchdogEnabled) {
                    statusMessage = "Neural Watchdog: Inactive"
                    delay(5000L)
                    continue
                }

                val manuallyStopped = ShizukuSettings.getManuallyStopped()
                if (manuallyStopped) {
                    statusMessage = "Neural Watchdog: Paused (Manual Stop)"
                    continue
                }

                val shizukuAlive = runCatching { Shizuku.pingBinder() }.getOrDefault(false)

                if (shizukuAlive) {
                    if (consecutiveFailures > 0) {
                        Diag.info(TAG, "Shizuku service auto-healed successfully!")
                    }
                    consecutiveFailures = 0
                    autoHealAttempts = 0
                    isAutoHealing = false
                    statusMessage = "Neural Watchdog: Bound & Protected"
                } else {
                    // Sudden disconnect detected!
                    consecutiveFailures++
                    autoHealAttempts = consecutiveFailures

                    if (consecutiveFailures <= MAX_RAPID_ATTEMPTS) {
                        isAutoHealing = true
                        statusMessage = "Neural Watchdog: Auto-Healing ($consecutiveFailures/$MAX_RAPID_ATTEMPTS)..."
                        Diag.warn(TAG, "Shizuku binder disconnected! Triggering auto-heal attempt $consecutiveFailures")

                        val healed = triggerAutoHealSequence(context)
                        if (healed) {
                            consecutiveFailures = 0
                            autoHealAttempts = 0
                            isAutoHealing = false
                            statusMessage = "Neural Watchdog: Restored & Protected"
                        } else {
                            val backoff = INITIAL_BACKOFF_MS * (1 shl (consecutiveFailures - 1))
                            delay(backoff)
                        }
                    } else {
                        // Max rapid attempts reached; enter quiet cooldown to save battery
                        isAutoHealing = false
                        statusMessage = "Neural Watchdog: Cooldown (30s) - Battery Save"
                        delay(30000L)
                        consecutiveFailures = 0
                    }
                }
            }
        }
    }

    fun stop() {
        monitorJob?.cancel()
        monitorJob = null
        isWatchdogActive = false
        isAutoHealing = false
        statusMessage = "Neural Watchdog: Inactive"
    }

    private suspend fun triggerAutoHealSequence(context: Context): Boolean = withContext(Dispatchers.IO) {
        try {
            // 1. Discover active local loopback ADB TCP port via Smart Local TCP Bridge
            val activePort = SmartLocalTcpBridge.discoverActiveAdbPort(context)

            if (activePort > 0) {
                // 2. Attempt restart on discovered active port
                runCatching { AdbStarter.startAdb(context.applicationContext, activePort) }
                delay(1200L)
                if (runCatching { Shizuku.pingBinder() }.getOrDefault(false)) {
                    return@withContext true
                }
            }

            // 3. Fallback: trigger ShizukuReceiverStarter background recovery
            runCatching { ShizukuReceiverStarter.start(context, reason = "auto_heal") }
            delay(1500L)
            return@withContext runCatching { Shizuku.pingBinder() }.getOrDefault(false)
        } catch (e: Throwable) {
            Diag.error(TAG, "Auto-heal sequence error: ${e.message}")
            return@withContext false
        }
    }
}
