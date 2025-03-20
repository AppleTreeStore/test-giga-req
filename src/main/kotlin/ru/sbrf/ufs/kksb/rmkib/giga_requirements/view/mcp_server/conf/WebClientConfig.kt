package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.conf

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.web.reactive.function.client.WebClient
import java.util.*

@Configuration
open class WebClientConfig {

    @Value("classpath:token.txt")
    private lateinit var tokenResource: Resource

    @Bean
    open fun webClient(): WebClient {
        val token = Scanner(tokenResource.inputStream).useDelimiter("\\A").next().trim()
        return WebClient.builder()
            .baseUrl("https://elizavetamartinovich1410.atlassian.net/wiki/rest/api/search")
            .defaultHeader("Authorization", "Basic $${token}")
            .defaultHeader("Content-Type", "application/json")
            .build()
    }
}