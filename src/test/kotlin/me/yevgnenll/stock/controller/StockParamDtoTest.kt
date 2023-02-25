package me.yevgnenll.stock.controller

import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.exception.StockException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StockParamDtoTest {

    @Test
    fun `정의되지 않은 파라미터를 받으면 에러가 반환된다`() {
        assertThrows<StockException> {
            StockParamDto("005930.KS", "1d", "someRange").validation()
        }.also {
            assertThat(it.code).isEqualTo(ApiResponseCode.BAD_REQUEST)
        }
    }
}