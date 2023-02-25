package me.yevgnenll.stock.controller

import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.exception.StockException

data class RequestParamDto(
    val symbol: String,
    val interval: String,
    val range: String,
) {
    companion object {
        val validRange = setOf(
            "1d", "5d", "1mo", "3mo", "6mo",
            "1y", "2y", "5y", "10y", "ytd",
            "max"
        )

        val validInterval = setOf(
            "1m", "2m", "5m", "15m", "30m",
            "60m", "90m", "1h", "1d", "5d",
            "1wk", "1mo", "3mo"
        )
    }

    fun validation() {
        if (!validRange.contains(range)) {
            throw StockException(ApiResponseCode.BAD_REQUEST, "Not permitted Range $range")
        }

        if (!validInterval.contains(interval)) {
            throw StockException(ApiResponseCode.BAD_REQUEST, "Not permitted Interval $interval")
        }
    }

}
