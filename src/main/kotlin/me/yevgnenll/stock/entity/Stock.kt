package me.yevgnenll.stock.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Stock(
    var id: Long? = null,
    val timestamp: LocalDate,
    var low: Double,
    var high: Double,
    val close: Double,
    val open: Double,
    var volume: Double,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
) {
    constructor(
        timestamp: LocalDate,
        low: Double, high: Double, close: Double, open: Double, volume: Double) : this(
        timestamp = timestamp,
        low = low,
        high = high,
        close = close,
        open = open,
        volume = volume,
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
    )
}