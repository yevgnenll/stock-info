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
}