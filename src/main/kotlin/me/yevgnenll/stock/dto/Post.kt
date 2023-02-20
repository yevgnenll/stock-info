package me.yevgnenll.stock.dto

data class Post(
    var timezone: String? = null,
    var end: Int? = null,
    var start: Int? = null,
    var gmtoffset: Int? = null
)