package me.yevgnenll.stock.dto.yahoo

import me.yevgnenll.stock.util.ReadApiResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class YahooResponseDtoTest {

    @Test
    fun `API timestamp 5개가 존재하는지 검증한다`() {
        ReadApiResponse.getApiResponse().exportStockEntity().let {
            assertThat(it.size).isEqualTo(5)
        }
    }

    @Test
    fun `API 5일전의 결과는 open-63600 volume-70606 high-63900 low-63200 close-63200 이다`() {
        ReadApiResponse.getApiResponse().exportStockEntity().first().let {
            assertThat(it.open).isEqualTo(63600)
            assertThat(it.close).isEqualTo(63200)
            assertThat(it.high).isEqualTo(63900)
            assertThat(it.low).isEqualTo(63200)
            assertThat(it.volume).isEqualTo(70606)
        }
    }
}