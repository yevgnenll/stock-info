package me.yevgnenll.stock.dto

import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.http.HttpStatus

data class ApiResponseDto(
    @Schema(description = "API에서 정의한 코드", defaultValue = "SUCCESS")
    val code: ApiCode,
    @Schema(description = "코드의 설명")
    val detail: String,
    @Schema(description = "반환 데이터")
    val data: Any? = null,
) {

    constructor(code: ApiCode, data: Any?) : this(
        code = code,
        detail = code.message,
        data = data
    )

    companion object {
        fun success(data: Any?) = ApiResponseDto(ApiCode.SUCCESS, data)
    }

}

enum class ApiCode(
    val message: String,
    val statusCode: HttpStatus,
) {
    SUCCESS("Success", HttpStatus.OK),
    ERROR("Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("Invalid Parameter", HttpStatus.BAD_REQUEST),
}
