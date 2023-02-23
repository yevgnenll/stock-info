package me.yevgnenll.stock.dto

data class ApiResponseDto(
    val code: ApiCode,
    val detail: String,
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

