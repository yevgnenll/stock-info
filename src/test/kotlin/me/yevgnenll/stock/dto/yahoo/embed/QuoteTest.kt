package me.yevgnenll.stock.dto.yahoo.embed

import me.yevgnenll.stock.exception.StockException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class QuoteTest {

    @Test
    fun `Quote 내부 collection들의 사이즈가 하나라도 timestamp 사이즈와 다르면 에러를 반환한다`() {

        assertThrows(StockException::class.java) {
            Quote(
                open = listOf(10, 10),
                close = listOf(11, 11, 11),
                high = listOf(12, 12, 12),
                low = listOf(13, 13, 13),
                volume = listOf(14, 14, 14)
            ).convertToStock(listOf(LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()), "name")
        }
    }

    @Test
    fun `Quote 내부 collection들의 사이즈가 timestamp와 일치하면 0을 반환한다`() {
        Quote(
            open = listOf(10, 10, 10),
            close = listOf(11, 11, 11),
            high = listOf(12, 12, 12),
            low = listOf(13, 13, 13),
            volume = listOf(14, 14, 14)
        ).xorAllCollectionSize(3).let {
            assertThat(it).isEqualTo(0)
        }
    }
}