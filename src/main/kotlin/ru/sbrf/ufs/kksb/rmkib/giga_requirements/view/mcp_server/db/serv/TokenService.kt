package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.serv

import TokenRepository
import org.springframework.stereotype.Service

@Service
class TokenService(private val tokenRepository: TokenRepository) {

    fun getToken(): String {
        val token = tokenRepository.findAll().firstOrNull()
        return token?.token ?: throw IllegalStateException("Token not found in the database")
    }
}