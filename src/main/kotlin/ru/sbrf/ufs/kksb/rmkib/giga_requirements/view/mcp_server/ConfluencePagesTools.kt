package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.ConfluencePagesControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq.ConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs.ConfluencePageRs

@RestController
@RequestMapping("/api/conf-pages/tools")
class ConfluencePagesTools(
    private val confluencePagesControllerApi: ConfluencePagesControllerApi
) {
    @PostMapping("/current-page")
    fun getCurrentConfluencePage(rq: ConfluencePageRq): ConfluencePageRs {
        return confluencePagesControllerApi.getCurrentConfluencePage(rq)
    }
}