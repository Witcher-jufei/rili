package com.yitools.rili.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yitools.rili.R
import com.yitools.rili.extensions.launchNewEventIntent
import com.yitools.rili.extensions.launchNewTaskIntent
import com.simplemobiletools.commons.dialogs.RadioGroupDialog
import com.simplemobiletools.commons.models.RadioItem

class EventTypePickerActivity : AppCompatActivity() {
    private val TYPE_EVENT = 0
    private val TYPE_TASK = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = arrayListOf(
            RadioItem(TYPE_EVENT, getString(R.string.event)),
            RadioItem(TYPE_TASK, getString(R.string.task))
        )
        RadioGroupDialog(this, items = items, cancelCallback = { dialogCancelled() }) {
            val checkedId = it as Int
            if (checkedId == TYPE_EVENT) {
                launchNewEventIntent()
            } else if (checkedId == TYPE_TASK) {
                launchNewTaskIntent()
            }
            finish()
        }
    }

    private fun dialogCancelled() {
        finish()
    }
}
