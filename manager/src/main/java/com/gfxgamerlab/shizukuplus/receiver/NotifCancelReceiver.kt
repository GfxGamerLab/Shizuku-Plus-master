package com.gfxgamerlab.shizukuplus.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.WorkManager
import com.gfxgamerlab.shizukuplus.ShizukuSettings
import com.gfxgamerlab.shizukuplus.ktx.ensureWorkManager
import com.gfxgamerlab.shizukuplus.service.LockedBootStartService
import com.gfxgamerlab.shizukuplus.receiver.ShizukuReceiverStarter
import com.gfxgamerlab.shizukuplus.utils.EnvironmentUtils
import com.gfxgamerlab.shizukuplus.worker.AdbStartWorker

class NotifCancelReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // A cancel is best effort: there may be no WorkManager to cancel anything in, and a stop
        // the user asked for must still happen when there is none.
        if (context.ensureWorkManager()) {
            runCatching {
                WorkManager.getInstance(context).cancelUniqueWork(AdbStartWorker.UNIQUE_WORK_NAME)
            }
        }
        LockedBootStartService.cancelRun("cancelled from the notification") {}
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.cancel(ShizukuReceiverStarter.NOTIFICATION_ID)
    }
}
