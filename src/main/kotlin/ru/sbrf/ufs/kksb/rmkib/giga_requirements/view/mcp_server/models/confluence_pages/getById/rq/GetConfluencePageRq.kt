package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.getById.rq

import com.fasterxml.jackson.annotation.JsonProperty

data class GetConfluencePageRq(
    @JsonProperty("id")
    var id: String? = null,
    @JsonProperty("format")
    var format: String? = null
)