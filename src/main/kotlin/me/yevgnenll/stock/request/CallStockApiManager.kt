package me.yevgnenll.stock.request

import me.yevgnenll.stock.config.YahooProperties
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
        symbol: String,
        interval: String,
        range: String,
    ): String = UriComponentsBuilder.fromPath(symbol)
        .queryParam("interval", interval)
        .queryParam("range", range)
        .build()
        .toUriString()

    fun requestStockData(
        symbol: String,
        interval: String,
        range: String,
    ): StockInfoDto = webClient.get()
        .uri(buildStockUri(symbol, interval, range))
        .retrieve()
        .bodyToMono(StockInfoDto::class.java)
        .block() ?: throw IllegalStateException()

}
