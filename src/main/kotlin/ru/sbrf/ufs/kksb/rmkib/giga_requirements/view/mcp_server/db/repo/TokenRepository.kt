import org.springframework.data.jpa.repository.JpaRepository
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.entity.Token

interface TokenRepository : JpaRepository<Token, Long> {
    fun findByToken(token: String): Token?
}