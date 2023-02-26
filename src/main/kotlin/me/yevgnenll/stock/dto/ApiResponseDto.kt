package me.yevgnenll.stock.dto

import me.yevgnenll.stock.exception.StockException

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

        private const val UNKNOWN_ERROR = "Unknown error."

        fun <T> success(data: T?) = ApiResponseDto(ApiResponseCode.SUCCESS, data)

        fun error(e: StockException) = error(e, e.message)

        fun error(e: Exception) = error(e, null)


        fun error(e: Exception, message: String?) =
            ApiResponseDto(
                ApiResponseCode.ERROR,
                message ?: e.message ?: UNKNOWN_ERROR,
                null
            )

    }

}

