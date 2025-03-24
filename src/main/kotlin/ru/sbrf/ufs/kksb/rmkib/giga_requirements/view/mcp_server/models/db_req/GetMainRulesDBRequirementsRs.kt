package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.db_req

data class GetMainRulesDBRequirementsRs(
    var rules: List<RuleRequirement>? = null
)

data class RuleRequirement(
    var name: String? = null,
    var desc: String? = null,
    var example: String? = null
)