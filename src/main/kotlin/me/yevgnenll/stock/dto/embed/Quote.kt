package me.yevgnenll.stock.dto.embed

import org.slf4j.LoggerFactory

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

    private fun validate(timestampSize: Int) {
        val xorResult = xorAllCollectionSize(timestampSize)

        if (xorResult != 0) {
            logger.error("Stock Quete data length is INVALID")
            throw IllegalArgumentException("Data is INVALID")
        }
    }

    fun separate(timestampSize: Int): List<QuoteItem> {
        validate(timestampSize)

        return volume.indices.map {
            QuoteItem(it, open, high, close, low, volume)
        }
    }
}

data class QuoteItem(
    val open: Double,
    val high: Double,
    val close: Double,
    val low: Double,
    val volume: Double,
) {
    constructor(
        index: Int,
        open: List<Double>,
        high: List<Double>,
        close: List<Double>,
        low: List<Double>,
        volume: List<Double>,
    ) : this(
        open = open[index],
        high = high[index],
        close = close[index],
        low = low[index],
        volume = volume[index],
    )
}