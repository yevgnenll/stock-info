package me.yevgnenll.stock.request

import me.yevgnenll.stock.config.YahooProperties
import me.yevgnenll.stock.controller.RequestParamDto
import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.dto.yahoo.StockInfoDto
import me.yevgnenll.stock.exception.StockException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.ClientResponse
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
        param: RequestParamDto
    ): String = UriComponentsBuilder.fromPath(param.symbol)
        .queryParam("interval", param.interval)
        .queryParam("range", param.range)
        .build()
        .toUriString()

    private fun error(error: ClientResponse, code: ApiResponseCode): Mono<StockException> =
        error.bodyToMono(StockInfoDto::class.java).flatMap {
            Mono.error(StockException(code, it.chart.error!!.description))
        }

    fun requestStockData(
        requestParamDto: RequestParamDto,
    ): StockInfoDto = webClient.get()
        .uri(buildStockUri(requestParamDto))
        .retrieve()
        .onStatus({
            status :HttpStatus -> status.is4xxClientError
        }) {
            error(it, ApiResponseCode.BAD_REQUEST)
        }.onStatus({
            status :HttpStatus -> status.is5xxServerError
        }) {
            error(it, ApiResponseCode.ERROR)
        }
        .bodyToMono(StockInfoDto::class.java)
        .block() ?: throw IllegalStateException()

}
