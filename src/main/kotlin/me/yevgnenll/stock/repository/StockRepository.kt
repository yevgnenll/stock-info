package me.yevgnenll.stock.repository

import me.yevgnenll.stock.entity.Stock
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface StockRepository: JpaRepository<Stock, Long> {

    fun findByTimestampAndName(timestamp: LocalDate, name: String): Stock?

}