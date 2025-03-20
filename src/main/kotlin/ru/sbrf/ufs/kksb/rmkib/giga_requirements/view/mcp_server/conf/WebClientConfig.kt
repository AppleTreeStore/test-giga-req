package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class WebClientConfig {
    @Bean
    open fun webClient(): WebClient = WebClient.builder()
        .baseUrl("https://elizavetamartinovich1410.atlassian.net/wiki/rest/api/search")
        .defaultHeader("Authorization", "Basic ")
        .defaultHeader("Content-Type", "application/json")
        .build()
}