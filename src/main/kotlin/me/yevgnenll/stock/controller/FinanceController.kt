package me.yevgnenll.stock.controller

import me.yevgnenll.stock.dto.StockInfoDto
import me.yevgnenll.stock.request.CallStockApiManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/finance"])
class FinanceController(
    private val callStockApiManager: CallStockApiManager,
) {

    // https://query1.finance.yahoo.com/v8/finance/chart/005930.KS?interval=1d&range=5d
    @GetMapping(path = ["/", ""])
    fun getFinanceInfo(): StockInfoDto {
        return callStockApiManager.requestStockData("005930.KS", "1d", "5d")
    }

}