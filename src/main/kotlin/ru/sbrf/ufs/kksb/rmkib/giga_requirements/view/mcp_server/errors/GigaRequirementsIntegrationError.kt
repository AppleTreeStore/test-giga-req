package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.errors

import java.util.UUID

class GigaRequirementsIntegrationError(
    uuid: String = UUID.randomUUID().toString(),
    code: String = "INTEGRATION",
    title: String,
    text: String,
): CommonError(
    uuid,
    code,
    title,
    text
)