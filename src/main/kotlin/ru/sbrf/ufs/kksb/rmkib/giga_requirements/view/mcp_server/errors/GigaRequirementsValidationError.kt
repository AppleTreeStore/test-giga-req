package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors

import java.util.UUID

class GigaRequirementsValidationError(
    uuid: String = UUID.randomUUID().toString(),
    code: String = "VALIDATION",
    title: String = "Ошибка валидации запроса/ответа",
    text: String,
): CommonError(
    uuid,
    code,
    title,
    text
)