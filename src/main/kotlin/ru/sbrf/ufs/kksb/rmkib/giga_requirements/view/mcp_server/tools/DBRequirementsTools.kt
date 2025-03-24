package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.tools

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.DBRequirementsControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common.BaseResponse
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.db_req.GetMainRulesDBRequirementsRs

@RestController
@RequestMapping("api/db-req/tools")
class DBRequirementsTools(
    private val dbRequirementsControllerApi: DBRequirementsControllerApi
) {
    private val logger = LoggerFactory.getLogger(ConfluencePagesTools::class.java)

    @GetMapping("/get-rules")
    fun getMainRules(): BaseResponse<GetMainRulesDBRequirementsRs> {
        logger.info("Получен вызов на ендпоинт api/db-req/tools/get-rules")
        return BaseResponse.success(logger) { dbRequirementsControllerApi.getRulesForMainRequirements() }
    }
}