package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.models.common

import ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors.CommonError

data class BaseResponse<T>(
    private var body: T? = null,
    private var success: Boolean? = null,
    private var error: CommonError? = null) {
     companion object {
         fun <T> success(body: T): BaseResponse<T> {
             return BaseResponse(
                 success = true,
                 body = body
             )
         }
     }
 }