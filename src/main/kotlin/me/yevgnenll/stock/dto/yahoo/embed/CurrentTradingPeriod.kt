package me.yevgnenll.stock.dto.yahoo.embed


data class CurrentTradingPeriod(

    val pre: Pre? = Pre(),
    val regular: Regular? = Regular(),
    val post: Post? = Post()

)