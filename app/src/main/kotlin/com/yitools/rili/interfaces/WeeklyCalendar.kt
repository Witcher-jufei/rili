package com.yitools.rili.interfaces

import com.yitools.rili.models.Event

interface WeeklyCalendar {
    fun updateWeeklyCalendar(events: ArrayList<Event>)
}
