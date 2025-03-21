package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.impl

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.ConfluencePagesControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq.ConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs.ConfluencePageRs

@Service
class ConfluencePagesControllerImpl(
    private val webClient: WebClient
): ConfluencePagesControllerApi {
    override fun getCurrentConfluencePage(rq: ConfluencePageRq): ConfluencePageRs {
        if (rq.id == null) {
            throw IllegalArgumentException("ID cannot be null")
        }
        val res = webClient.get()
            .uri("/pages/${rq.id}")
            .retrieve()
            .bodyToMono(String::class.java)
            .doOnSuccess { response ->
                logger.info("Успешный ответ: $response")
            }
            .doOnError { error ->
                logger.error("Ошибка при получении ответа: ${error.message}", error)
            }
            .block();
        return ConfluencePageRs(data = res)
    }
}