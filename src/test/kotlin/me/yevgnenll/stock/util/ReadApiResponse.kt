package me.yevgnenll.stock.util

import com.fasterxml.jackson.databind.ObjectMapper
import me.yevgnenll.stock.dto.yahoo.StockInfoDto
import org.springframework.util.ResourceUtils

class ReadApiResponse {

    companion object {

        private val stockInfo = readStockInfoDto()

        private fun readStockInfoDto(): StockInfoDto {
            val objectMapper = ObjectMapper()
            return ResourceUtils.getFile("classpath:2023Feb20.json").let {
                objectMapper.readValue(it.readText(Charsets.UTF_8), StockInfoDto::class.java)
            }
        }

        fun getApiResponse(): StockInfoDto {
            return stockInfo
        }
    }

}