package me.yevgnenll.stock.dto

import me.yevgnenll.stock.entity.Stock
import java.time.LocalDate

data class StockResponseDto(
    val date: LocalDate,
    val name: String,
    val high: Int,
    val low: Int,
    val open: Int,
    val close: Int,
    val volume: Int,
) {
    constructor(stock: Stock): this(
        name = stock.name,
        date = stock.timestamp,
        high = stock.high,
        low = stock.low,
        open = stock.open,
        close = stock.close,
        volume = stock.volume,
    )
}