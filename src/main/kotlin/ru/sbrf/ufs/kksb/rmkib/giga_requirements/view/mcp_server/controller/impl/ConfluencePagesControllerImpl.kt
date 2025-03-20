package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.impl

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
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
            .uri("/rest/api/content/{${rq.id}}")
            .retrieve()
            .bodyToMono(String::class.java)
            .block();
        return ConfluencePageRs(data = res)
    }
}