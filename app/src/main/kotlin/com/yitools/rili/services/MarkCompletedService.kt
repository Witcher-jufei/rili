package com.yitools.rili.services

import android.app.IntentService
import android.content.Intent
import com.yitools.rili.extensions.eventsDB
import com.yitools.rili.extensions.updateTaskCompletion
import com.yitools.rili.helpers.ACTION_MARK_COMPLETED
import com.yitools.rili.helpers.EVENT_ID

class MarkCompletedService : IntentService("MarkCompleted") {

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {
        if (intent != null && intent.action == ACTION_MARK_COMPLETED) {
            val taskId = intent.getLongExtra(EVENT_ID, 0L)
            val task = eventsDB.getTaskWithId(taskId)
            if (task != null) {
                updateTaskCompletion(task, completed = true)
            }
        }
    }
}
