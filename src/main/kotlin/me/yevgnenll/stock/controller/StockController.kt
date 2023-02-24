package me.yevgnenll.stock.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import me.yevgnenll.stock.dto.ApiResponseDto
import me.yevgnenll.stock.dto.StockResponseDto
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
        ]
    )
    @GetMapping(path = [""])
    fun getFinanceInfo(): ApiResponseDto<List<StockResponseDto>?> {
        return stockService.findFiveDays().map {
            StockResponseDto(it)
        }.let {
            ApiResponseDto.success(it)
        }
    }

}