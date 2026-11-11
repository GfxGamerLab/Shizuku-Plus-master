package com.gfxgamerlab.shizukuplus.settings

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gfxgamerlab.shizukuplus.utils.AppLocale

class BugReportDialogActivity : AppCompatActivity() {

    /** The dialog is shown from the settings screen, so it has to speak the same language. */
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(AppLocale.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BugReportDialog().show(supportFragmentManager, "BugReportDialog")
    }
}