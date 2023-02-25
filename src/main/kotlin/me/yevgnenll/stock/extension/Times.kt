package me.yevgnenll.stock.extension

import me.yevgnenll.stock.config.KST_TIMEZONE
import me.yevgnenll.stock.config.UTC_TIMEZONE
import java.time.LocalDateTime
import java.time.ZonedDateTime


private fun LocalDateTime.convertUtcToKstZonedDateTime(): ZonedDateTime =
    atZone(UTC_TIMEZONE).withZoneSameInstant(KST_TIMEZONE)

private fun LocalDateTime.convertKstToUtcZonedDateTime(): ZonedDateTime =
    atZone(KST_TIMEZONE).withZoneSameInstant(UTC_TIMEZONE)

fun LocalDateTime.convertKstToUtc(): LocalDateTime =
    convertKstToUtcZonedDateTime().toLocalDateTime()