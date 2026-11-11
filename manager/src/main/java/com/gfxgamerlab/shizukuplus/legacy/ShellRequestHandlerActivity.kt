package com.gfxgamerlab.shizukuplus.legacy

import android.os.Bundle
import android.widget.Toast
import com.gfxgamerlab.shizukuplus.app.AppActivity
import com.gfxgamerlab.shizukuplus.shell.ShellBinderRequestHandler

class ShellRequestHandlerActivity : AppActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ShellBinderRequestHandler.handleRequest(this, intent)
        finish()
    }
}
