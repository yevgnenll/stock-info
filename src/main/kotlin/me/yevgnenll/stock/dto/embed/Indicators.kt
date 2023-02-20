package me.yevgnenll.stock.dto.embed


data class Indicators(
    val quote: List<Quote> = listOf(),
    val adjclose: List<Adjclose> = listOf(),
)