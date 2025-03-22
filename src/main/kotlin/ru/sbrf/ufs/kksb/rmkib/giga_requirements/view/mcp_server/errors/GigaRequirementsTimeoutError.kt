package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors

import java.util.UUID

class GigaRequirementsTimeoutError(
    uuid: String = UUID.randomUUID().toString(),
    code: String = "TIMEOUT",
    title: String = "Таймаут при вызове сервиса",
    text: String,
): CommonError(
    uuid,
    code,
    title,
    text
)