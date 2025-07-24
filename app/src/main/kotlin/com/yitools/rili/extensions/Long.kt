package com.yitools.rili.extensions

import com.yitools.rili.helpers.Formatter
import com.yitools.rili.models.Event

fun Long.isTsOnProperDay(event: Event): Boolean {
    val dateTime = Formatter.getDateTimeFromTS(this)
    val power = Math.pow(2.0, (dateTime.dayOfWeek - 1).toDouble()).toInt()
    return event.repeatRule and power != 0
}
