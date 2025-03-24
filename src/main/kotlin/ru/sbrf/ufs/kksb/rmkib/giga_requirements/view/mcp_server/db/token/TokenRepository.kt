package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.token

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.token.entity.Token

@Repository
interface TokenRepository : JpaRepository<Token, Long> {
    fun findByToken(token: String): Token?
}