package me.yevgnenll.stock.dto


data class Regular(
    val timezone: String? = null,
    val end: Int? = null,
    val start: Int? = null,
    val gmtoffset: Int? = null
)