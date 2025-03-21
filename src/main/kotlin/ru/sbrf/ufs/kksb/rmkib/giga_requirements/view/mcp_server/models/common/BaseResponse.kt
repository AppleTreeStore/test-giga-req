package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common

import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.CommonError
import java.util.logging.Logger

data class BaseResponse<T>(
    private var body: T? = null,
    private var success: Boolean? = null,
    private var error: CommonError? = null) {
     companion object {
         fun <T> success(logger: Logger, body: T): BaseResponse<T> {
             logger.info("Возвращаем успешный ответ: $body")
             return BaseResponse(
                 success = true,
                 body = body
             )
         }
     }
 }