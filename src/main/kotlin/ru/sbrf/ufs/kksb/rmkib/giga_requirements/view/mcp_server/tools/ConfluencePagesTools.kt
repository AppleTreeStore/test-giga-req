package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.tools

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.ConfluencePagesControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common.BaseResponse
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq.ConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs.ConfluencePageRs

@RestController
@RequestMapping("api/conf-pages/tools")
class ConfluencePagesTools(
    private val confluencePagesControllerApi: ConfluencePagesControllerApi
) {
    private val logger = LoggerFactory.getLogger(ConfluencePagesTools::class.java)
    @PostMapping("/current-page")
    fun getCurrentConfluencePage(@RequestBody rq: ConfluencePageRq): BaseResponse<ConfluencePageRs> {
        logger.info("Получен вызов на ендпоинт api/conf-pages/tools/current-page. RQ: $rq")
        return BaseResponse.success(logger) { confluencePagesControllerApi.getCurrentConfluencePage(rq) }
    }

    @PostMapping("/ce")
    fun getCurrentConfluencePge(rq: ConfluencePageRq): String {
        return "123"
    }
}