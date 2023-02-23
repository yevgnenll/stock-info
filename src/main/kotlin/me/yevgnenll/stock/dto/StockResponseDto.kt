package me.yevgnenll.stock.dto

import io.swagger.v3.oas.annotations.media.Schema
import me.yevgnenll.stock.config.DATE_FORMAT
import me.yevgnenll.stock.entity.Stock
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class StockResponseDto(
    @Schema(description = "해당 주식의 날짜")
    @field:DateTimeFormat(pattern = DATE_FORMAT)
    val date: LocalDate,

    @Schema(description = "주식의 이름")
    val name: String,

    @Schema(description = "이 주식의 해당 날짜 최고가")
    val high: Int,

    @Schema(description = "이 주식의 해당 날짜 최저가")
    val low: Int,

    @Schema(description = "개장 시작 가격")
    val open: Int,

    @Schema(description = "개장 종료 가격")
    val close: Int,

    @Schema(description = "주식의 해당 날짜의 거래량")
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