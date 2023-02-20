package me.yevgnenll.stock.dto

data class Quote(
    val open: ArrayList<Double> = arrayListOf(),
    val high: ArrayList<Double> = arrayListOf(),
    val close: ArrayList<Double> = arrayListOf(),
    val low: ArrayList<Double> = arrayListOf(),
    val volume: ArrayList<Double> = arrayListOf()
)