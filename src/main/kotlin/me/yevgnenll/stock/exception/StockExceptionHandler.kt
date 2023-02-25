package me.yevgnenll.stock.exception

import me.yevgnenll.stock.dto.ApiResponseDto
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class StockExceptionHandler {

    companion object {
        private val logger = LoggerFactory.getLogger(StockExceptionHandler::class.java)
    }

    @ExceptionHandler(StockException::class)
    fun handleStockException(
        e: StockException
    ): ApiResponseDto<Nothing> {
        if (e.code.isClientError()) {
            logger.warn("Client Error: {}", e.message)
        }
        if (e.code.isServerError()) {
            logger.error("Server Error: {}", e.message)
        }
        return ApiResponseDto.error(e)
    }

}