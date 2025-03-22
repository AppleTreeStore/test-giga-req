package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.entity

import jakarta.persistence.*

@Entity
@Table(name = "token-bd")
data class Token(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "token", length = 1000)
    val token: String
)  {
    constructor() : this(null, "")
}

