package com.yitools.rili.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.yitools.rili.extensions.*
import com.simplemobiletools.commons.helpers.ensureBackgroundThread

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        ensureBackgroundThread {
            context.apply {
                scheduleAllEvents()
                notifyRunningEvents()
                recheckCalDAVCalendars(true) {}
                scheduleNextAutomaticBackup()
                checkAndBackupEventsOnBoot()
            }
        }
    }
}
