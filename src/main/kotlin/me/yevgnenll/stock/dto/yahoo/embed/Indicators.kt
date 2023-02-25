package me.yevgnenll.stock.dto.yahoo.embed

import me.yevgnenll.stock.entity.Stock
import java.time.LocalDateTime


data class Indicators(
    val quote: List<Quote> = listOf(),
    val adjclose: List<Adjclose> = listOf(),
) {
    fun exportEntities(timestamp: List<LocalDateTime>, name: String): List<Stock> {
        return quote.map {
            it.convertTo(timestamp, name)
        }.flatten()
    }
}