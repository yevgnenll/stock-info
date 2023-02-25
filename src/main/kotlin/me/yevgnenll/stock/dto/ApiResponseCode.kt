package me.yevgnenll.stock.dto

import org.springframework.http.HttpStatus

enum class ApiResponseCode(
    val message: String,
    val statusCode: HttpStatus,
) {
    SUCCESS("Success", HttpStatus.OK),
    ERROR("Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("Invalid Parameter", HttpStatus.BAD_REQUEST),
    ;

    fun isClientError(): Boolean = statusCode.is4xxClientError

    fun isServerError(): Boolean = statusCode.is5xxServerError
}