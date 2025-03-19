package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api

import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq.ConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs.ConfluencePageRs

interface ConfluencePagesControllerApi {
    fun getCurrentConfluencePage(rq: ConfluencePageRq): ConfluencePageRs
}