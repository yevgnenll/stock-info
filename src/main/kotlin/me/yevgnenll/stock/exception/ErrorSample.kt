package me.yevgnenll.stock.exception


const val BAD_REQUEST_ERROR_EXAMPLE = """
{
    "code": "BAD_REQUEST",
    "detail": "222d is invalid, 1d, 5d, 1mo, 3mo, 6mo, 1y, 2y, 5y, 10y, ytd, max",
    "data": null
}
"""

const val SERVER_ERROR_EXAMPLE = """
{
    "code": "ERROR",
    "detail": "Server Error",
    "data": null
}
"""