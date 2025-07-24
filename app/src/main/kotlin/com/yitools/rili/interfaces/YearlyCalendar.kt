package com.yitools.rili.interfaces

import android.util.SparseArray
import com.yitools.rili.models.DayYearly
import java.util.*

interface YearlyCalendar {
    fun updateYearlyCalendar(events: SparseArray<ArrayList<DayYearly>>, hashCode: Int)
}
