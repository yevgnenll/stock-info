package me.yevgnenll.stock.request

import me.yevgnenll.stock.config.YahooProperties
import me.yevgnenll.stock.controller.StockParamDto
import me.yevgnenll.stock.dto.yahoo.StockInfoDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder

@Component
class CallStockApiManager(
    yahooProperties: YahooProperties,
) {

    private val webClient: WebClient = WebClient.builder()
        .baseUrl(yahooProperties.financeUrl)
        .build()

    private fun buildStockUri(
        param: StockParamDto
    ): String = UriComponentsBuilder.fromPath(param.symbol)
        .queryParam("interval", param.interval)
        .queryParam("range", param.range)
        .build()
        .toUriString()

    fun requestStockData(
        stockParamDto: StockParamDto,
    ): StockInfoDto = webClient.get()
        .uri(buildStockUri(stockParamDto))
        .retrieve()
        .bodyToMono(StockInfoDto::class.java)
        .block() ?: throw IllegalStateException()

}
