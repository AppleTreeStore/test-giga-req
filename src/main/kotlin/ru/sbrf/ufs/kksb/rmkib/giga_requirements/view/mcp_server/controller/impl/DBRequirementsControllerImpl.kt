package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.impl

import org.springframework.stereotype.Service
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.controller.api.DBRequirementsControllerApi
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.QualityRequirementRepository
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.QualityRuleRepository
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token.QualityRequirement
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.mappers.toGetMainRulesDBRequirementsRs
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.db_req.GetMainRulesDBRequirementsRs

@Service
class DBRequirementsControllerImpl(
    private val requirementRepository: QualityRequirementRepository,
    private val ruleRepository: QualityRuleRepository
): DBRequirementsControllerApi {

    override fun getMainRequirements(): List<QualityRequirement> {
        return requirementRepository.findByIsMain(true)
    }

    override fun getRulesForMainRequirements(): GetMainRulesDBRequirementsRs {
        val res = ruleRepository.findByRequirementIsMain(true)
        return res.toGetMainRulesDBRequirementsRs()
    }
}