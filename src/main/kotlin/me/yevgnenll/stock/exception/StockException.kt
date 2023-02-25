package me.yevgnenll.stock.exception

import me.yevgnenll.stock.dto.ApiResponseCode

class StockException : RuntimeException {

    var code: ApiResponseCode = ApiResponseCode.ERROR

    constructor(code: ApiResponseCode) : super(code.message) {
        this.code = code
    }

    constructor(code: ApiResponseCode, message: String) : super(message) {
        this.code = code
    }

    constructor(code: ApiResponseCode, message: String, cause: Throwable) : super(message, cause) {
        this.code = code
    }

    constructor(code: ApiResponseCode, cause: Throwable) : super(cause) {
        this.code = code
    }

}