package ru.sbrf.ufs.kksb.rmkib.giga_requirements.view.mcp_server.db.requirements.token

import jakarta.persistence.*

@Entity
@Table(name = "QualityRequirements")
data class QualityRequirement(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String? = null,

    @Column(nullable = false)
    val isMain: Boolean? = null,

    @OneToMany(mappedBy = "requirement", fetch = FetchType.LAZY)
    val rules: List<QualityRule>? = null
) {
    constructor() : this(null, "", false, emptyList())
}
