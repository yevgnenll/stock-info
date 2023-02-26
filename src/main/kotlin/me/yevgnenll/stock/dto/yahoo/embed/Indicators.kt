package me.yevgnenll.stock.dto.yahoo.embed


data class Indicators(
    // size 대부분이 1이다.
    val quote: List<Quote> = listOf(),
    val adjclose: List<Adjclose> = listOf(),
)