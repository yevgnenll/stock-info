package me.yevgnenll.stock.dto

import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.util.ResourceUtils

class StockInfoDtoTest {


    private val stockInfo = readStockInfoDto()

    private fun readStockInfoDto(): StockInfoDto {
        val objectMapper = ObjectMapper()
        return ResourceUtils.getFile("classpath:2023Feb20.json").let {
            objectMapper.readValue(it.readText(Charsets.UTF_8), StockInfoDto::class.java)
        }
    }

    @Test
    fun `API timestamp 5개가 존재하는지 검증한다`() {
        stockInfo.exportStockEntity().let {
            assertThat(it.size).isEqualTo(5)
        }
    }

    @Test
    fun `API 5일전의 결과는 open-63600 volume-70606 high-63900 low-63200 close-63200 이다`() {
        stockInfo.exportStockEntity().first().let {
            assertThat(it.open).isEqualTo(63600)
            assertThat(it.close).isEqualTo(63200)
            assertThat(it.high).isEqualTo(63900)
            assertThat(it.low).isEqualTo(63200)
            assertThat(it.volume).isEqualTo(70606)
        }
    }
}