package me.yevgnenll.stock.dto.yahoo

import me.yevgnenll.stock.entity.Stock


data class YahooResponseDto(
    val chart: Chart = Chart()
) {

    fun exportStockEntity(): List<Stock> {
        return chart.result?.map {
            it.separateStockInfo()
        }?.flatten() ?: listOf()
    }
}