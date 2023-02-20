package me.yevgnenll.stock.dto


data class Indicators(
    val quote: ArrayList<Quote> = arrayListOf(),
    val adjclose: ArrayList<Adjclose> = arrayListOf()
)