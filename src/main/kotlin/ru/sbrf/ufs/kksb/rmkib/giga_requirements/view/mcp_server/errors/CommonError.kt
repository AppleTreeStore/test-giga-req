package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors

open class CommonError(
    private val uuid: String,
    private val code: String?,
    private val title: String,
    private val text: String
): Exception() {
    fun getUUID(): String = uuid
    fun getCode(): String? = code
    fun getTitle(): String = title
    fun getTExt(): String = text
}