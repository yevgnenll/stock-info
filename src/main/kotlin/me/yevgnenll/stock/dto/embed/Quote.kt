package me.yevgnenll.stock.dto.embed

import me.yevgnenll.stock.entity.Stock
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

data class Quote(
    val open: List<Double> = listOf(),
    val high: List<Double> = listOf(),
    val close: List<Double> = listOf(),
    val low: List<Double> = listOf(),
    val volume: List<Double> = listOf()
) {

    companion object {
        private val logger = LoggerFactory.getLogger(javaClass)
    }

    internal fun xorAllCollectionSize(timestampSize: Int): Int =
        open.size xor high.size xor close.size xor low.size xor volume.size xor timestampSize

    private fun isNotMatched(xorResult: Int): Boolean = xorResult != 0

    private fun validate(timestampSize: Int) {
        val xorResult = xorAllCollectionSize(timestampSize)

        if (isNotMatched(xorResult)) {
            logger.error("Stock Quete data length is INVALID")
            throw IllegalArgumentException("Data is INVALID")
        }
    }

    private fun convertTo(index: Int, timestamp: List<LocalDateTime>): Stock =
        Stock(timestamp[index].toLocalDate(),
            open[index], high[index], close[index], low[index], volume[index])

    fun convertTo(timestamp: List<LocalDateTime>): List<Stock> {
        validate(timestamp.size)
        return timestamp.indices.map {
            convertTo(it, timestamp)
        }
    }
}
