package com.yitools.rili.models

data class DayMonthly(
    val value: Int,
    val isThisMonth: Boolean,
    val isToday: Boolean,
    val code: String,
    val weekOfYear: Int,
    var dayEvents: ArrayList<Event>,
    var indexOnMonthView: Int,
    var isWeekend: Boolean
)
