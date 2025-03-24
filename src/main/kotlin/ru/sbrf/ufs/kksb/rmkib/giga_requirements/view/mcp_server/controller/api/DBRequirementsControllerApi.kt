package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api

import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token.QualityRequirement
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token.QualityRule
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.db_req.GetMainRulesDBRequirementsRs

interface DBRequirementsControllerApi {
    fun getMainRequirements(): List<QualityRequirement>
    fun getRulesForMainRequirements(): GetMainRulesDBRequirementsRs
}