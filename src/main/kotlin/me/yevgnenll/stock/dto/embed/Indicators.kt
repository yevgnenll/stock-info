package me.yevgnenll.stock.dto.embed


data class Indicators(
    val quote: ArrayList<Quote> = arrayListOf(),
    val adjclose: ArrayList<Adjclose> = arrayListOf()
)