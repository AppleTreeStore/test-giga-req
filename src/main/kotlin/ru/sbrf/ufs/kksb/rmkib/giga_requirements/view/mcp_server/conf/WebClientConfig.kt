package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.conf

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class WebClientConfig {

    @Bean
    open fun webClient(): WebClient {
        return WebClient.builder()
            .baseUrl("https://elizavetamartinovich1410.atlassian.net/wiki")
            .defaultHeader("Authorization", "Basic ${System.getenv("auth-token")}")
            .defaultHeader("Content-Type", "application/json")
            .build()
    }
}