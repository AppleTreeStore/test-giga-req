package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.conf

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class WebClientConfig {
    private val logger = LoggerFactory.getLogger(WebClientConfig::class.java)
    @Bean
    open fun webClient(): WebClient {
        logger.info("Получаем токен-апи")
        try {
            val token = System.getenv("auth-token")
        } catch (ex: Exception) {
            logger.error("Ошибка получения токена: $ex")
        }
        return WebClient.builder()
            .baseUrl("https://elizavetamartinovich1410.atlassian.net/wiki/api/v2")
            .defaultHeader("Authorization", "Basic $token")
            .defaultHeader("Content-Type", "application/json")
            .build()
    }
}