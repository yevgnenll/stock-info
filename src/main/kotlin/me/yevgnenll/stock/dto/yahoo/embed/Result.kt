package me.yevgnenll.stock.dto.yahoo.embed

import me.yevgnenll.stock.config.UTC_TIMEZONE
import me.yevgnenll.stock.entity.Stock
import java.time.Instant
import java.time.LocalDateTime


data class Result(
    val meta: Meta = Meta(),
    val timestamp: List<Long> = arrayListOf(),
    val indicators: Indicators = Indicators()
) {

    private fun timestampConvertTo(timestamp: Long): LocalDateTime {
        return LocalDateTime.ofInstant(
            Instant.ofEpochSecond(timestamp),
            UTC_TIMEZONE
        )
    }

    fun timestampConvertTo(): List<LocalDateTime> {
        return timestamp.map {
            timestampConvertTo(it)
        }.toList()
    }

    fun separateStockInfo(): List<Stock> {
        return indicators.quote.map {
            it.convertToStock(timestampConvertTo(), meta.symbol!!)
        }.flatten()
    }
}