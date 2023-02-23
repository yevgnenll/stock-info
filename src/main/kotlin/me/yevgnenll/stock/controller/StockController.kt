package me.yevgnenll.stock.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import me.yevgnenll.stock.dto.ApiResponseDto
import me.yevgnenll.stock.dto.StockResponseDto
import me.yevgnenll.stock.service.StockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/stocks"])
class StockController(
    private val stockService: StockService,
) {

    @Tag(name = "저장된 주식 반환 API", description = "저장된 5일치의 주식 데이터를 날짜 기준 오름차순으로 반환합니다.")
    @Operation(
        responses = [ApiResponse(
            responseCode = "200", description = "주식 데이터 5일치 반환 성공",
            content = [Content(schema = Schema(implementation = ApiResponseDto::class))])
        ],
        description = "주식 데이터 5일치 반환"
    )
    @GetMapping(path = ["/", ""])
    fun getFinanceInfo(): ApiResponseDto {
        return stockService.findFiveDays().map {
            StockResponseDto(it)
        }.let {
            ApiResponseDto.success(it)
        }
    }

}