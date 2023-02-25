package me.yevgnenll.stock.util

import com.fasterxml.jackson.databind.ObjectMapper
import me.yevgnenll.stock.dto.yahoo.YahooResponseDto
import org.springframework.util.ResourceUtils

class ReadApiResponse {

    companion object {

        private val stockInfo = readStockInfoDto()

        private fun readStockInfoDto(): YahooResponseDto {
            val objectMapper = ObjectMapper()
            return ResourceUtils.getFile("classpath:2023Feb20.json").let {
                objectMapper.readValue(it.readText(Charsets.UTF_8), YahooResponseDto::class.java)
            }
        }

        fun getApiResponse(): YahooResponseDto {
            return stockInfo
        }
    }

}