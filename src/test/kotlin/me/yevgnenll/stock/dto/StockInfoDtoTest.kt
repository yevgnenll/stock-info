package me.yevgnenll.stock.dto

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.util.ResourceUtils

class StockInfoDtoTest {

    private val objectMapper = ObjectMapper()

    private fun readStockInfoDto(): StockInfoDto =
        ResourceUtils.getFile("classpath:testResult.json").let {
            objectMapper.readValue(it.readText(Charsets.UTF_8), StockInfoDto::class.java)
        }

    @Test
    fun `API 날짜들이 올바르게 추출되는지 검증한다`() {
        readStockInfoDto().exportStockEntity().let {
            assertThat(it.size).isEqualTo(5)
        }
    }

    @Test
    fun `API 5일전의 결과는 open-63600 volume-70606 high-63900 low-63200 close-63200 이다`() {
        readStockInfoDto().exportStockEntity()[0].let {
            assertThat(it.open).isEqualTo(63600.0)
            assertThat(it.close).isEqualTo(63200.0)
            assertThat(it.high).isEqualTo(63900.0)
            assertThat(it.low).isEqualTo(63200.0)
            assertThat(it.volume).isEqualTo(70606.0)
        }
    }
}