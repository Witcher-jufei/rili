package com.yitools.rili.extensions

import com.yitools.rili.models.MonthViewEvent

fun MonthViewEvent.shouldStrikeThrough() = isTaskCompleted || isAttendeeInviteDeclined
