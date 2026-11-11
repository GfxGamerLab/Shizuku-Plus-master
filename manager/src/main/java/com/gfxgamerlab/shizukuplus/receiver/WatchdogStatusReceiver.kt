package com.gfxgamerlab.shizukuplus.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.gfxgamerlab.shizukuplus.ShizukuSettings

class WatchdogStatusReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        resultData = if (ShizukuSettings.getWatchdog()) "1" else "0"
    }
}
