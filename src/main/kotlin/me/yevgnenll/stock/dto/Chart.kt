package me.yevgnenll.stock.dto


data class Chart(
    val result: List<Result> = arrayListOf(),
    val error: String? = null
)