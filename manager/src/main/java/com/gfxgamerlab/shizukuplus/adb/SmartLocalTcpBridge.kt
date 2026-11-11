package com.gfxgamerlab.shizukuplus.adb

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.gfxgamerlab.shizukuplus.ShizukuSettings
import com.gfxgamerlab.shizukuplus.utils.runShellCommand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.InetSocketAddress
import java.net.Socket

object SmartLocalTcpBridge {

    var activeBridgePort by mutableIntStateOf(-1)
        private set

    /**
     * Fast scan to discover local loopback ADB port when Wireless Debugging changes ports dynamically.
     * Checks classic port 5555, last recorded port, system properties, and /proc/net/tcp ports.
     */
    suspend fun discoverActiveAdbPort(context: Context): Int = withContext(Dispatchers.IO) {
        if (!ShizukuSettings.getSmartLocalTcpBridge()) {
            activeBridgePort = -1
            return@withContext -1
        }
        // 1. Check last recorded port from ShizukuSettings
        val lastPort = ShizukuSettings.getLastAdbPort()
        if (lastPort > 0 && isPortOpen(lastPort)) {
            activeBridgePort = lastPort
            return@withContext lastPort
        }

        // 2. Check default classic ADB port 5555
        if (isPortOpen(5555)) {
            activeBridgePort = 5555
            ShizukuSettings.setLastAdbPort(5555)
            return@withContext 5555
        }

        // 3. Query system properties for TLS / ADB wifi port
        val propPort = runShellCommand("getprop service.adb.tls.port 2>/dev/null")?.trim()?.toIntOrNull()
        if (propPort != null && propPort > 0 && isPortOpen(propPort)) {
            activeBridgePort = propPort
            ShizukuSettings.setLastAdbPort(propPort)
            return@withContext propPort
        }

        // 4. Scan listening TCP ports from /proc/net/tcp in Wireless Debugging range (30000..49151)
        val candidatePorts = findListeningPortsFromNetstat()
        for (port in candidatePorts) {
            if (isPortOpen(port)) {
                activeBridgePort = port
                ShizukuSettings.setLastAdbPort(port)
                return@withContext port
            }
        }

        activeBridgePort = -1
        return@withContext -1
    }

    private fun isPortOpen(port: Int): Boolean {
        return try {
            Socket().use { socket ->
                socket.connect(InetSocketAddress("127.0.0.1", port), 80)
                true
            }
        } catch (_: Throwable) {
            false
        }
    }

    private fun findListeningPortsFromNetstat(): List<Int> {
        return try {
            val output = runShellCommand("cat /proc/net/tcp /proc/net/tcp6 2>/dev/null") ?: ""
            output.lines()
                .mapNotNull { line ->
                    val parts = line.trim().split("\\s+".toRegex())
                    if (parts.size >= 4 && parts[3] == "0A") { // 0A = TCP LISTEN
                        val localAddr = parts[1]
                        val portHex = localAddr.substringAfterLast(":", "")
                        portHex.toIntOrNull(16)
                    } else null
                }
                .filter { it in 30000..49151 || it == 5555 }
                .distinct()
        } catch (_: Throwable) {
            emptyList()
        }
    }
}
