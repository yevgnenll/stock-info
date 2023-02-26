package me.yevgnenll.stock.dto.yahoo.embed

import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.entity.Stock
import me.yevgnenll.stock.exception.StockException
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

data class Quote(
    val open: List<Long> = listOf(),
    val high: List<Long> = listOf(),
    val close: List<Long> = listOf(),
    val low: List<Long> = listOf(),
    val volume: List<Long> = listOf()
) {

    companion object {
        private val logger = LoggerFactory.getLogger(Quote::class.java)
    }

    internal fun xorAllCollectionSize(timestampSize: Int): Int =
        open.size xor high.size xor close.size xor low.size xor volume.size xor timestampSize

    private fun isNotMatched(xorResult: Int): Boolean = xorResult != 0

    private fun validate(timestampSize: Int) {
        val xorResult = xorAllCollectionSize(timestampSize)

        if (isNotMatched(xorResult)) {
            logger.error("Stock Quete data length is INVALID")
            throw StockException(ApiResponseCode.INVALID_STOCK_SIZE)
        }
    }

    private fun convertToStock(index: Int, timestamp: List<LocalDateTime>, name: String): Stock =
        Stock(timestamp, name, this, index)

    fun convertToStock(timestamp: List<LocalDateTime>, name: String): List<Stock> {
        validate(timestamp.size)
        return timestamp.indices.map {
            convertToStock(it, timestamp, name)
        }
    }
}
