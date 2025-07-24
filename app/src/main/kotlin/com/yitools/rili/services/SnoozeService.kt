package com.yitools.rili.services

import android.app.IntentService
import android.content.Intent
import com.yitools.rili.extensions.config
import com.yitools.rili.extensions.eventsDB
import com.yitools.rili.extensions.rescheduleReminder
import com.yitools.rili.helpers.EVENT_ID

class SnoozeService : IntentService("Snooze") {
    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val eventId = intent.getLongExtra(EVENT_ID, 0L)
            val event = eventsDB.getEventOrTaskWithId(eventId)
            rescheduleReminder(event, config.snoozeTime)
        }
    }
}
