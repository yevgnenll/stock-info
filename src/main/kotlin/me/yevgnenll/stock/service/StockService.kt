package me.yevgnenll.stock.service

import me.yevgnenll.stock.controller.RequestParamDto
import me.yevgnenll.stock.entity.Stock
import me.yevgnenll.stock.repository.StockRepository
import me.yevgnenll.stock.request.CallYahooApiManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StockService(
    private val stockRepository: StockRepository,
    private val callYahooApiManager: CallYahooApiManager,
) {

    private fun updateOrCreate(stock: Stock): Stock {
        return stockRepository.findByTimestampAndName(stock.timestamp, stock.name)?.also {
            it.update(stock)
        } ?: stock
    }

    private fun saveStockList(stockList: List<Stock>): List<Stock> {
        return stockList.map {
            updateOrCreate(it)
        }.map {
            stockRepository.save(it)
        }
    }

    @Transactional
    fun findFiveDays(requestParamDto: RequestParamDto): List<Stock> =
        callYahooApiManager.requestStockData(requestParamDto).exportStockEntity().also {
            saveStockList(it)
        }
}