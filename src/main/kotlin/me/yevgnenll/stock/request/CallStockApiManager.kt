package me.yevgnenll.stock.request

import me.yevgnenll.stock.config.YahooProperties
import me.yevgnenll.stock.controller.StockParamDto
import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.dto.yahoo.StockInfoDto
import me.yevgnenll.stock.exception.StockException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono


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
        .onStatus({
            status :HttpStatus -> status.is4xxClientError
        }) {
            it.bodyToMono(StockInfoDto::class.java).flatMap {
                return@flatMap Mono.error(StockException(ApiResponseCode.BAD_REQUEST, it.chart.error!!.description))
            }
        }.onStatus({
            status :HttpStatus -> status.is5xxServerError
        }) {
            it.bodyToMono(StockInfoDto::class.java).flatMap {
                return@flatMap Mono.error(StockException(ApiResponseCode.ERROR, it.chart.error!!.description))
            }
        }
        .bodyToMono(StockInfoDto::class.java)
        .block() ?: throw IllegalStateException()

}
