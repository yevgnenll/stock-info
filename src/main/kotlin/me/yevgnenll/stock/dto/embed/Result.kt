package me.yevgnenll.stock.dto.embed

import me.yevgnenll.stock.config.UTC_TIMEZONE
import me.yevgnenll.stock.entity.Stock
import java.time.Instant
import java.time.LocalDateTime


data class Result(
    val meta: Meta = Meta(),
    val timestamp: List<Long> = arrayListOf(),
    val indicators: Indicators = Indicators()
) {

    private fun convertTo(timestamp: Long): LocalDateTime {
        return LocalDateTime.ofInstant(
            Instant.ofEpochSecond(timestamp),
            UTC_TIMEZONE
        )
    }

    fun convertTo(): List<LocalDateTime> {
        return timestamp.map {
            convertTo(it)
        }.toList()
    }

    fun separateStockInfo(): List<Stock> {
        return indicators.exportEntities(convertTo(), meta.symbol!!)
    }
}