package me.yevgnenll.stock.dto

import me.yevgnenll.stock.dto.embed.Result


data class Chart(
    val result: List<Result> = listOf(),
    val error: String? = null
)