package me.yevgnenll.stock.dto.embed

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class QuoteTest {

    @Test
    fun `Quote 내부 collection들의 사이즈가 하나라도 timestamp 사이즈와 다르면 에러를 반환한다`() {

        assertThrows(IllegalArgumentException::class.java) {
            Quote(
                open = listOf(10.0, 10.0),
                close = listOf(11.0, 11.0, 11.0),
                high = listOf(12.0, 12.0, 12.0),
                low = listOf(13.0, 13.0, 13.0),
                volume = listOf(14.0, 14.0, 14.0)
            ).convertTo(listOf(LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()))
        }
    }

    @Test
    fun `Quote 내부 collection들의 사이즈가 timestamp와 일치하면 0을 반환한다`() {
        Quote(
            open = listOf(10.0, 10.0, 10.0),
            close = listOf(11.0, 11.0, 11.0),
            high = listOf(12.0, 12.0, 12.0),
            low = listOf(13.0, 13.0, 13.0),
            volume = listOf(14.0, 14.0, 14.0)
        ).xorAllCollectionSize(3).let {
            assertThat(it).isEqualTo(0)
        }
    }
}