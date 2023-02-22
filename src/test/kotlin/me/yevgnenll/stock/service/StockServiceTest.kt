package me.yevgnenll.stock.service

import me.yevgnenll.stock.repository.StockRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class StockServiceTest {

    @Autowired
    lateinit var stockRepository: StockRepository

    @Test
    fun `test`() {




    }
}