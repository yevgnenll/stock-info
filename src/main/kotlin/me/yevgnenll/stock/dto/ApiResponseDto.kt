package me.yevgnenll.stock.dto

data class ApiResponseDto<T>(
    val code: ApiCode,
    val detail: String,
    val data: T? = null,
) {

    constructor(code: ApiCode, data: T) : this(
        code = code,
        detail = code.message,
        data = data
    )

    companion object {
        fun <T> success(data: T?) = ApiResponseDto(ApiCode.SUCCESS, data)

    }

}

