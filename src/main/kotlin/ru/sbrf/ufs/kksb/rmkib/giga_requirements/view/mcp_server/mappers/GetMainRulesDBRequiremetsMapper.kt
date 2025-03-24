package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.mappers

import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token.QualityRule
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.db_req.GetMainRulesDBRequirementsRs
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.db_req.RuleRequirement

fun List<QualityRule>.toGetMainRulesDBRequirementsRs(): GetMainRulesDBRequirementsRs {
    return GetMainRulesDBRequirementsRs(
        rules = this.map { rule -> RuleRequirement(
            name = rule.name,
            desc = rule.description,
            example = rule.example
        ) }
    )
}