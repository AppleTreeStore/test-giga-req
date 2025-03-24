package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token.QualityRequirement

@Repository
interface QualityRequirementRepository: JpaRepository<QualityRequirement, Long> {
    fun findByIsMain(isMain: Boolean): List<QualityRequirement>
}