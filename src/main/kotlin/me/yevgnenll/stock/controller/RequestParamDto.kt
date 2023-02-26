package me.yevgnenll.stock.controller

import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.exception.StockException

data class RequestParamDto(
    val symbol: String,
    val interval: String? = "1d",
    val range: String,
) {
    companion object {
        private val validRange = setOf(
            "1d", "5d", "1mo", "3mo", "6mo",
            "1y", "2y", "5y", "10y", "ytd",
            "max"
        )

        // 확장을 고려해 남겨둔다
        private val validInterval = setOf(
            "1d",
        )
    }

    fun validation() {
        if (!validRange.contains(range)) {
            throw StockException(ApiResponseCode.BAD_REQUEST,
                "$range is invalid, ${validRange.joinToString(", ")}")
        }

        if (!validInterval.contains(interval)) {
            throw StockException(ApiResponseCode.BAD_REQUEST,
                "$interval is invalid, ${validInterval.joinToString(", ")}")
        }
    }

}
