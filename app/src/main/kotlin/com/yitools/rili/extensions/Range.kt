package com.yitools.rili.extensions

import android.util.Range

fun Range<Int>.intersects(other: Range<Int>) = (upper >= other.lower && lower <= other.upper) || (other.upper >= lower && other.lower <= upper)
