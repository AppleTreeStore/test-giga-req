package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common

import com.fasterxml.jackson.annotation.JsonProperty
import org.slf4j.Logger
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.CommonError
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.GigaRequirementsIntegrationError
import java.util.UUID

data class BaseResponse<T>(
    @JsonProperty("body")
    var body: T? = null,
    @JsonProperty("success")
    var success: Boolean? = null,
    @JsonProperty("error")
    var error: CommonError? = null
) {

    companion object {
        fun <T> success(logger: Logger, body: () -> T): BaseResponse<T> {
            val result = try {
                body.invoke()
            } catch (ex: Exception) {
                return BaseResponse(
                    success = false,
                    body = null,
                    error = GigaRequirementsIntegrationError(
                        text = ex.message.toString()
                    )
                )
            }
            logger.info("Возвращаем успешный ответ: $result")
            return BaseResponse(
                success = true,
                body = result
            )
        }
    }
}