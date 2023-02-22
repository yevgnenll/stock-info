package me.yevgnenll.stock.controller

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

    @GetMapping(path = ["/", ""])
    fun getFinanceInfo(): List<StockResponseDto> {
        return stockService.findFiveDays().map {
            StockResponseDto(it)
        }
    }

}