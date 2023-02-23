package me.yevgnenll.stock.config

import java.time.ZoneId

const val DATE_FORMAT = "yyyy-MM-dd"
const val DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"

const val UTC_TIMEZONE_ID = "UTC"
const val KOREA_TIMEZONE_ID = "Asia/Seoul"

val UTC_TIMEZONE = ZoneId.of(UTC_TIMEZONE_ID)
val KST_TIMEZONE: ZoneId = ZoneId.of(KOREA_TIMEZONE_ID)
