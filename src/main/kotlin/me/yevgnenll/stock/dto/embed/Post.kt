package me.yevgnenll.stock.dto.embed

data class Post(
    var timezone: String? = null,
    var end: Int? = null,
    var start: Int? = null,
    var gmtoffset: Int? = null
)