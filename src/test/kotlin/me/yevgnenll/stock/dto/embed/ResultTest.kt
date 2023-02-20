package me.yevgnenll.stock.dto.embed

import me.yevgnenll.stock.config.UTC_TIMEZONE
import me.yevgnenll.stock.dto.embed.Result
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

import org.assertj.core.api.Assertions.assertThat
class ResultTest {

    @Test
    fun `timestamp 1676332800를 LocalDateTime(2023-02-14) 으로 변경한다`() {
        LocalDateTime.ofInstant(
            Instant.ofEpochSecond(1_676_332_800),
            UTC_TIMEZONE
        ).let {
            assertThat(it).isEqualTo(LocalDateTime.of(2023, 2, 14, 0, 0, 0, 0))
        }
    }

    @Test
    fun `timestamp 1676419200를 2023-02-15로 변경한다`() {
        Result(timestamp = listOf(1676419200)).let {
            it.convertTo()
        }.first().let {
            assertThat(it).isEqualTo(LocalDateTime.of(2023, 2, 15, 0, 0, 0, 0))
        }
    }
}