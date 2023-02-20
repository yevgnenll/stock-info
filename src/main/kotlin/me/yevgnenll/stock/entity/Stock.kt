package me.yevgnenll.stock.entity

import java.time.LocalDate
import java.time.LocalDateTime

data class Stock(
    val id: Long? = null,
    val timestamp: LocalDate,
    val low: Double,
    val high: Double,
    val close: Double,
    val open: Double,
    val volume: Double,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)