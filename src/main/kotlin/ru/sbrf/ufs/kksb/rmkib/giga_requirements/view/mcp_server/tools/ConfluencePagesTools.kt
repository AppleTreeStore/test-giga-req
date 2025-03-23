package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.tools

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.ConfluencePagesControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common.BaseResponse
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rq.GetConfluencePageRq
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.confluence_pages.rs.GetConfluencePageRs

@RestController
@RequestMapping("api/conf-pages/tools")
class ConfluencePagesTools(
    private val confluencePagesControllerApi: ConfluencePagesControllerApi
) {
    private val logger = LoggerFactory.getLogger(ConfluencePagesTools::class.java)
    @PostMapping("/current-page")
    fun getConfluencePage(@RequestBody rq: GetConfluencePageRq): BaseResponse<GetConfluencePageRs> {
        logger.info("Получен вызов на ендпоинт api/conf-pages/tools/current-page. RQ: $rq")
        return BaseResponse.success(logger) { confluencePagesControllerApi.getConfluencePage(rq) }
    }

    @PostMapping("/update-page")
    fun updateConfluencePage(rq: GetConfluencePageRq): String {
        return "123"
    }
}