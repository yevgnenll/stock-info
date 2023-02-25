package me.yevgnenll.stock.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import me.yevgnenll.stock.dto.ApiResponseDto
import me.yevgnenll.stock.dto.StockResponseDto
import me.yevgnenll.stock.exception.BAD_REQUEST_ERROR_EXAMPLE
import me.yevgnenll.stock.exception.SERVER_ERROR_EXAMPLE
import me.yevgnenll.stock.service.StockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "stockController", description = "주식 조회 API")
@RestController
@RequestMapping(path = ["/stocks"])
class StockController(
    private val stockService: StockService,
) {

    @Operation(
        description = "주식 조회",
        responses = [
            ApiResponse(responseCode = "200", description = "성공"),
            ApiResponse(responseCode = "400", description = "Invalid param",
                content = [Content(examples = [ExampleObject(BAD_REQUEST_ERROR_EXAMPLE)])]
            ),
            ApiResponse(responseCode = "500", description = "Server Error",
                content = [Content(examples = [ExampleObject(SERVER_ERROR_EXAMPLE)])]
            ),
        ],
        parameters = [
            Parameter(name = "symbol", description = "주식의 상장 코드", example = "005930.KS"),
            Parameter(name = "interval", description = "주식 데이터 조회 단위", example = "1d"),
            Parameter(name = "range", description = "주식 데이터 조회 범위", example = "5d"),
        ]
    )
    @GetMapping(path = [""])
    fun getFinanceInfo(
        requestParamDto: RequestParamDto,
    ): ApiResponseDto<List<StockResponseDto>?> {
        requestParamDto.validation()
        return stockService.findFiveDays(requestParamDto).map {
            StockResponseDto(it)
        }.let {
            ApiResponseDto.success(it)
        }
    }

}