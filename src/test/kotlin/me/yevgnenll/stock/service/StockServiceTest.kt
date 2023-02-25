package me.yevgnenll.stock.service

import me.yevgnenll.stock.controller.RequestParamDto
import me.yevgnenll.stock.repository.StockRepository
import me.yevgnenll.stock.request.CallStockApiManager
import me.yevgnenll.stock.util.ReadApiResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@SpringBootTest
@Transactional
class StockServiceTest {

    @Autowired
    private lateinit var stockService: StockService

    @MockBean
    @Autowired
    private lateinit var callStockApiManager: CallStockApiManager

    @Autowired
    private lateinit var stockRepository: StockRepository

    fun mockingApi(param: RequestParamDto) {
        Mockito.`when`(
            callStockApiManager.requestStockData(param)
        ).then {
            ReadApiResponse.getApiResponse()
        }
    }

    @Test
    fun `API에서 받아온 데이터를 저장한다`() {
        val param = RequestParamDto(
            symbol = "005930.KS",
            interval = "1d",
            range = "5d"
        ).also {
            mockingApi(it)
        }.also {
            stockService.findFiveDays(it)
        }

        val date = LocalDate.of(2023, 2, 17)

        stockRepository.findByTimestampAndName(date, param.symbol).also {
            assertThat(it).isNotNull
        }
    }

    @Test
    fun `동일한 요청을 2번(이상) 수행하더라도 저장된 주식 데이터는 오로지 1개이다`() {
        val param = RequestParamDto(
            symbol = "005930.KS",
            interval = "1d",
            range = "5d"
        ).also {
            mockingApi(it)
        }.also {
            stockService.findFiveDays(it)
            stockService.findFiveDays(it)
        }

        val date = LocalDate.of(2023, 2, 17)

        assertDoesNotThrow {
            stockRepository.findByTimestampAndName(date, param.symbol)
        }
        stockRepository.countByTimestampAndName(date, param.symbol).also {
            assertThat(it).isEqualTo(1)
        }

    }

}