package me.yevgnenll.stock.service

import me.yevgnenll.stock.entity.Stock
import me.yevgnenll.stock.repository.StockRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StockService(
    private val stockRepository: StockRepository,
) {

    @Transactional
    fun saveStockList(stockList: List<Stock>): List<Stock> {
        return stockRepository.saveAll(stockList)
    }

}