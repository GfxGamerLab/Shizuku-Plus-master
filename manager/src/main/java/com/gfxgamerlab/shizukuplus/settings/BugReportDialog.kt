package com.gfxgamerlab.shizukuplus.settings

import android.app.Dialog
import android.app.NotificationManager
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.launch
import com.gfxgamerlab.shizukuplus.R
import com.gfxgamerlab.shizukuplus.databinding.BugReportDialogBinding
import com.gfxgamerlab.shizukuplus.ktx.asLink
import com.gfxgamerlab.shizukuplus.ktx.applyTemplateArgs
import com.gfxgamerlab.shizukuplus.utils.CustomTabsHelper
import com.gfxgamerlab.shizukuplus.utils.shareAppLog
import com.gfxgamerlab.shizukuplus.worker.AdbStartWorker

class BugReportDialog : DialogFragment() {

    private lateinit var binding: BugReportDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val context = requireContext()
        binding = BugReportDialogBinding.inflate(layoutInflater)

        val updateLink = getString(R.string.bug_report_dialog_link_update)
            .asLink("https://t.me/gfxgamerlab")

        val wikiLink = getString(R.string.bug_report_dialog_link_wiki)
            .asLink("https://t.me/gfxgamerlab")

        val issuesLink = getString(R.string.bug_report_dialog_link_issues)
            .asLink("https://t.me/gfxgamerlab")

        binding.apply {
            updateText.applyTemplateArgs(updateLink)
            wikiText.applyTemplateArgs(wikiLink)
            issuesText.applyTemplateArgs(issuesLink)
            methodText.applyTemplateArgs("Telegram Support")
            shareLog.setOnClickListener { shareLog() }
        }

        return MaterialAlertDialogBuilder(context)
            .setTitle(R.string.settings_report_bug)
            .setView(binding.root)
            .setPositiveButton("Telegram Support") { _, _ ->
                CustomTabsHelper.launchUrlOrCopy(context, ISSUES_NEW)
            }
            .setNeutralButton(android.R.string.cancel) { dialog, _ ->
                dialog.cancel()
            }
            .create()
    }

    private fun shareLog() {
        lifecycleScope.launch {
            val context = context ?: return@launch
            if (!shareAppLog(context)) {
                Toast.makeText(context, R.string.log_share_failed, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        val nm = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nm.cancel(AdbStartWorker.NOTIFICATION_ID)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (activity is BugReportDialogActivity) activity?.finish()
    }

    private companion object {
        const val ISSUES_NEW = "https://t.me/gfxgamerlab"
    }
}
