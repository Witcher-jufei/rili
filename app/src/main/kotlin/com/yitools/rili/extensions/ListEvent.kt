package com.yitools.rili.extensions

import com.yitools.rili.models.ListEvent

fun ListEvent.shouldStrikeThrough() = isTaskCompleted || isAttendeeInviteDeclined
