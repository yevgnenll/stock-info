package me.yevgnenll.stock.dto

import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Schema

data class ApiResponseDto(
    @Schema(description = "API에서 정의한 코드", defaultValue = "SUCCESS")
    val code: ApiCode,
    @Schema(description = "코드의 설명")
    val detail: String,
    @ArraySchema(
        schema = Schema(description = "반환 데이터", oneOf = [StockResponseDto::class])
    )
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

