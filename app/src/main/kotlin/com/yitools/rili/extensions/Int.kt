package com.yitools.rili.extensions

import com.yitools.rili.helpers.MONTH
import com.yitools.rili.helpers.WEEK
import com.yitools.rili.helpers.YEAR

fun Int.isXWeeklyRepetition() = this != 0 && this % WEEK == 0

fun Int.isXMonthlyRepetition() = this != 0 && this % MONTH == 0

fun Int.isXYearlyRepetition() = this != 0 && this % YEAR == 0
