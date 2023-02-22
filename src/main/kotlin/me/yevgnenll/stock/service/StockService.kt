package me.yevgnenll.stock.service

import me.yevgnenll.stock.entity.Stock
import me.yevgnenll.stock.repository.StockRepository
import me.yevgnenll.stock.request.CallStockApiManager
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct

@Service
class StockService(
    private val stockRepository: StockRepository,
    private val callStockApiManager: CallStockApiManager,
) {

    @PostConstruct
    private fun initStockData() {
        // https://query1.finance.yahoo.com/v8/finance/chart/005930.KS?interval=1d&range=5d
        return callStockApiManager.requestStockData("005930.KS", "1d", "5d").let {
            it.exportStockEntity()
        }.let {
            saveStockList(it)
        }
    }

    private fun updateOrCreate(stock: Stock): Stock {
        return stockRepository.findByTimestampAndName(stock.timestamp, stock.name)?.also {
            it.update(stock)
        } ?: stock
    }

    @Transactional
    fun saveStockList(stockList: List<Stock>): List<Stock> {
        return stockList.map {
            updateOrCreate(it)
        }.map {
            stockRepository.save(it)
        }
    }

    @Transactional(readOnly = true)
    fun findFiveDays(): List<Stock> {
        return stockRepository.findTop5ByNameOrderByTimestampDesc("005930.KS").sortedBy {
            it.timestamp
        }
    }

}