package me.yevgnenll.stock.dto.yahoo

import me.yevgnenll.stock.dto.yahoo.embed.Result


data class Chart(
    val result: List<Result>? = listOf(),
    val error: YahooError? = null
)

data class YahooError(
    val code: String,
    val description: String,
)