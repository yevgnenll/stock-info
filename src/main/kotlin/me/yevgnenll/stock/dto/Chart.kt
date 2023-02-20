package me.yevgnenll.stock.dto

import me.yevgnenll.stock.dto.embed.Result


data class Chart(
    val result: List<Result> = arrayListOf(),
    val error: String? = null
)