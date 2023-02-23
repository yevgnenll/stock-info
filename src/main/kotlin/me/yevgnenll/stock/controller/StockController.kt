package me.yevgnenll.stock.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import me.yevgnenll.stock.dto.StockResponseDto
import me.yevgnenll.stock.service.StockService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "stockController", description = "주식 5일치 API")
@RestController
@RequestMapping(path = ["/stocks"])
class StockController(
    private val stockService: StockService,
) {

    @Operation(
        description = "주식 데이터 5일치 반환",
        tags = ["stockController"]
    )
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200", description = "주식 데이터 5일치 반환 성공",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(arraySchema = Schema(implementation = StockResponseDto::class)))
            ],
        ),
        ]
    )
    @GetMapping(path = [""])
    fun getFinanceInfo(): List<StockResponseDto> {
        return stockService.findFiveDays().map {
            StockResponseDto(it)
        }
    }

}