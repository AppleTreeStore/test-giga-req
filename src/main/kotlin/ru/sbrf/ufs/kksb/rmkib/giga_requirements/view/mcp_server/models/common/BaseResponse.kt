package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common

import com.fasterxml.jackson.annotation.JsonProperty
import org.slf4j.Logger
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.CommonError
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.GigaRequirementsIntegrationError
import java.util.UUID

data class BaseResponse<T>(
    @JsonProperty("body")
    private var body: T? = null,
    @JsonProperty("success")
    private var success: Boolean? = null,
    @JsonProperty("error")
    private var error: CommonError? = null) {

     companion object {
         fun <T> success(logger: Logger, body: () -> T): BaseResponse<T> {
             val result = try {
                 body.invoke()
             } catch (ex: Exception) {
                 when (ex) {
                     is CommonError -> return BaseResponse(
                         success = false,
                         body = null,
                         error = ex
                     )
                     else -> return BaseResponse(
                         success = false,
                         body = null,
                         error = GigaRequirementsIntegrationError(
                             text = ex.message.toString()
                         )
                     )
                 }
             }
             logger.info("Возвращаем успешный ответ: $result")
             return BaseResponse(
                 success = true,
                 body = result
             )
         }
     }
 }