package me.yevgnenll.stock.dto

import me.yevgnenll.stock.config.DATE_FORMAT
import me.yevgnenll.stock.entity.Stock
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class StockResponseDto(
    @field:DateTimeFormat(pattern = DATE_FORMAT)
    val date: LocalDate,
    val name: String,
    val high: Long,
    val low: Long,
    val open: Long,
    val close: Long,
    val volume: Long,
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