package me.yevgnenll.stock.controller

import me.yevgnenll.stock.dto.ApiResponseCode
import me.yevgnenll.stock.exception.StockException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RequestParamDtoTest {

    @Test
    fun `정의되지 않은 range 파라미터를 받으면 400 에러를 반환된다`() {
        assertThrows<StockException> {
            RequestParamDto("005930.KS", "1d", "someRange").validation()
        }.also {
            assertThat(it.code).isEqualTo(ApiResponseCode.BAD_REQUEST)
        }
    }

    @Test
    fun `정의되지 않은 interval 파라미터를 받으면 400 에러를 반환한다`() {
        assertThrows<StockException> {
            RequestParamDto("005930.KS", "999d", "5d").validation()
        }.also {
            assertThat(it.code).isEqualTo(ApiResponseCode.BAD_REQUEST)
        }
    }
}