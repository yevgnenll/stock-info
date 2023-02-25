package me.yevgnenll.stock.dto.yahoo

import me.yevgnenll.stock.entity.Stock


data class StockInfoDto(
    val chart: Chart = Chart()
) {

    fun exportStockEntity(): List<Stock> {
        return chart.result?.map {
            it.separateStockInfo()
        }!!.flatten()
    }
}