package com.yitools.rili.services

import android.content.Intent
import android.widget.RemoteViewsService
import com.yitools.rili.adapters.EventListWidgetAdapterEmpty

class WidgetServiceEmpty : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent) = EventListWidgetAdapterEmpty(applicationContext)
}
