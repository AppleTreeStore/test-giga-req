package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.conf

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.reactive.function.client.WebClient
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.entity.Token
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.serv.TokenService

@Configuration
open class WebClientConfig(private val tokenService: TokenService) {
    private val logger = LoggerFactory.getLogger(WebClientConfig::class.java)

    @Bean
    open fun webClient(): WebClient {
        val token = tokenService.getToken() // Получаем токен из базы данных
        logger.info("Получили токен из БД")
        return WebClient.builder()
            .baseUrl("https://elizavetamartinovich1410.atlassian.net/wiki/api/v2")
            .defaultHeader("Authorization", "Basic $token")
            .defaultHeader("Accept", "application/json")
            .build()
    }
}