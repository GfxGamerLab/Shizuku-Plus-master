package com.gfxgamerlab.shizukuplus.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.gfxgamerlab.shizukuplus.AppConstants
import com.gfxgamerlab.shizukuplus.ShizukuSettings
import com.gfxgamerlab.shizukuplus.service.LockedBootStartService
import com.gfxgamerlab.shizukuplus.worker.AdbStartWorker

class NotifAttemptReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Retry the method the start was asked for, not whatever is default now.
        val startMethod = intent.getIntExtra(
            AppConstants.EXTRA_START_METHOD,
            ShizukuSettings.getStartMethod()
        )

        // User-initiated ("Retry now") never wait for Wi-Fi. It replaces the start in flight, and
        // one the foreground service began before the unlock is not queued work for the enqueue
        // to replace: it is cancelled first, and the new one queued once it has really ended.
        LockedBootStartService.cancelRun("attempt now from the notification") {
            AdbStartWorker.enqueue(context, startMethod = startMethod, immediate = true)
        }
    }
}
