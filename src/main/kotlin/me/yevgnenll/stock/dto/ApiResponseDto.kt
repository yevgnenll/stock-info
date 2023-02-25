package me.yevgnenll.stock.dto

import me.yevgnenll.stock.exception.StockException
import java.lang.Exception

data class ApiResponseDto<T>(
    val code: ApiResponseCode,
    val detail: String,
    val data: T? = null,
) {

    constructor(code: ApiResponseCode, data: T) : this(
        code = code,
        detail = code.message,
        data = data
    )

    companion object {
        fun <T> success(data: T?) = ApiResponseDto(ApiResponseCode.SUCCESS, data)

        fun error(e: StockException) = ApiResponseDto(e.code, e.message ?: e.localizedMessage, null)

        fun error(e: Exception) = ApiResponseDto(ApiResponseCode.ERROR, e.message ?: e.localizedMessage, null)

    }

}

