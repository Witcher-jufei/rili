package com.yitools.rili.extensions

import org.joda.time.DateTime

fun DateTime.seconds() = millis / 1000L
