package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.ConfluencePagesControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.getById.rq.GetConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.getById.rs.GetConfluencePageRs

@Service
class ConfluencePagesControllerImpl(
    private val webClient: WebClient
): ConfluencePagesControllerApi {
    private val logger = LoggerFactory.getLogger(ConfluencePagesControllerImpl::class.java)

    override fun getConfluencePage(rq: GetConfluencePageRq): GetConfluencePageRs {
        logger.info("Вызов метода getCurrentConfluencePage")
        if (rq.id == null) {
            throw IllegalArgumentException("ID страницы не может быть null")
        }
        logger.info("Вызываем получение страницы по id через Confluence API")
        val res = webClient.get()
            .uri("/pages/${rq.id}?body-format=${rq.format}")
            .retrieve()
            .bodyToMono(String::class.java)
            .doOnSuccess { response ->
                logger.info("Успешный ответ: $response")
            }
            .doOnError { error ->
                logger.error("Ошибка при получении ответа: ${error.message}", error)
            }
            .block()
        return GetConfluencePageRs(data = res)
    }
}