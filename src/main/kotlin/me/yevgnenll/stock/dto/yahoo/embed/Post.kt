package me.yevgnenll.stock.dto.yahoo.embed

data class Post(
    var timezone: String? = null,
    var end: Int? = null,
    var start: Int? = null,
    var gmtoffset: Int? = null
)