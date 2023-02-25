package me.yevgnenll.stock.controller

import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.exception.StockException

data class StockParamDto(
    val symbol: String,
    val interval: String,
    val range: String,
) {
    companion object {
        val validRange = setOf(
            "1d",
            "5d",
            "1mo",
            "3mo",
            "6mo",
            "1y",
            "2y",
            "5y",
            "10y",
            "ytd",
            "max"
        )
    }

    fun validation() {
        if (!validRange.contains(range)) {
            throw StockException(ApiResponseCode.BAD_REQUEST, "Not permitted Range")
        }
    }

}
