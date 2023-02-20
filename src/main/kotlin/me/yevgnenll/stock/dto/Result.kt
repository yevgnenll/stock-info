package me.yevgnenll.stock.dto


data class Result(
    val meta: Meta? = Meta(),
    val timestamp: ArrayList<Int> = arrayListOf(),
    val indicators: Indicators = Indicators()
)