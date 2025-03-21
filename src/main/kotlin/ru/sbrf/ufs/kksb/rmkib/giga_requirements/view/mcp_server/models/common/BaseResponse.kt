package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common

import org.slf4j.Logger
import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.CommonError

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