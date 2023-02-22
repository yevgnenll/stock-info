package me.yevgnenll.stock.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Stock(
    var id: Long? = null,
    val timestamp: LocalDate,
    var low: Int,
    var high: Int,
    val close: Int,
    val open: Int,
    var volume: Int,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
) {
    constructor(
        timestamp: LocalDate,
        low: Double, high: Double, close: Double, open: Double, volume: Double) : this(
        timestamp = timestamp,
        low = low.toInt(),
        high = high.toInt(),
        close = close.toInt(),
        open = open.toInt(),
        volume = volume.toInt(),
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
    )
}