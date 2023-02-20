package me.yevgnenll.stock.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "yahoo")
@ConstructorBinding
data class YahooProperties(
    val financeUrl: String,
)