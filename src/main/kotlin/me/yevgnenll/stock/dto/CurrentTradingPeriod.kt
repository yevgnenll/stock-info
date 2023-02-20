package me.yevgnenll.stock.dto


data class CurrentTradingPeriod(

    val pre: Pre? = Pre(),
    val regular: Regular? = Regular(),
    val post: Post? = Post()

)