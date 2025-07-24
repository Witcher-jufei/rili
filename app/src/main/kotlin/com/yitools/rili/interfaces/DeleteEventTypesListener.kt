package com.yitools.rili.interfaces

import com.yitools.rili.models.EventType
import java.util.*

interface DeleteEventTypesListener {
    fun deleteEventTypes(eventTypes: ArrayList<EventType>, deleteEvents: Boolean): Boolean
}
