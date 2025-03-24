package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token

import jakarta.persistence.*

@Entity
@Table(name = "QualityRules")
data class QualityRule(
    @Id
    @Column(name = "id", length = 10)
    val id: String? = null,

    @Column(nullable = false)
    val name: String? = null,

    val description: String? = null,

    val example: String? = null,

    @ManyToOne
    @JoinColumn(name = "requirement_id", referencedColumnName = "id")
    private val requirement: QualityRequirement? = null
) {
    constructor() : this(null, "", "", "")
}
