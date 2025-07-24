package com.yitools.rili.services

import android.content.Intent
import android.widget.RemoteViewsService
import com.yitools.rili.adapters.EventListWidgetAdapter

class WidgetService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent) = EventListWidgetAdapter(applicationContext, intent)
}
