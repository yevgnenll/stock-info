package me.yevgnenll.stock.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun stockOpenApi(): GroupedOpenApi =
        GroupedOpenApi.builder()
            .group("/stocks/**")
            .pathsToMatch("")
            .build()

    @Bean
    fun producerRestFulApi(): OpenAPI = OpenAPI()
        .info(Info()
            .title("Stock API")
            .description("Stock API의 명세서 입니다.")
            .version("1.0.0")
        ).also {
            it.addServersItem(Server().url("http://localhost:8080/stocks"))
        }
}