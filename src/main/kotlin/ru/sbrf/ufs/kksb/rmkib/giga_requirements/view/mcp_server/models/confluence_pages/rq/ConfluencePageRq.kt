package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq

import com.fasterxml.jackson.annotation.JsonProperty

data class ConfluencePageRq(
    @JsonProperty("id")
    var id: String? = null,
    @JsonProperty("format")
    var format: String? = null
)