package com.yitools.rili.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.yitools.rili.extensions.config
import com.yitools.rili.extensions.recheckCalDAVCalendars
import com.yitools.rili.extensions.refreshCalDAVCalendars
import com.yitools.rili.extensions.updateWidgets

class CalDAVSyncReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (context.config.caldavSync) {
            context.refreshCalDAVCalendars(context.config.caldavSyncedCalendarIds, false)
        }

        context.recheckCalDAVCalendars(true) {
            context.updateWidgets()
        }
    }
}
