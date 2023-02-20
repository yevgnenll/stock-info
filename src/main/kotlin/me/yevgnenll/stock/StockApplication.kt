package me.yevgnenll.stock

import me.yevgnenll.stock.config.YahooProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [YahooProperties::class])
class StockApplication

fun main(args: Array<String>) {
	runApplication<StockApplication>(*args)
}
