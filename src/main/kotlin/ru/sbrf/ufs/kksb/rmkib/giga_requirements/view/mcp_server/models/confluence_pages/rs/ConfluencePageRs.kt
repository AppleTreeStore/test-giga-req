package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs

import com.fasterxml.jackson.annotation.JsonProperty

data class ConfluencePageRs(
    @JsonProperty("data")
    var data: String? = null
)
