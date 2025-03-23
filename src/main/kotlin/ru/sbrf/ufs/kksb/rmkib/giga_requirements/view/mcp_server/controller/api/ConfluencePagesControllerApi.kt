package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api

import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq.GetConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs.GetConfluencePageRs

interface ConfluencePagesControllerApi {
    fun getConfluencePage(rq: GetConfluencePageRq): GetConfluencePageRs
}