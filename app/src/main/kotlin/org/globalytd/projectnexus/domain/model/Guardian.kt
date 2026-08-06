package org.globalytd.projectnexus.domain.model

enum class GuardianStatus { PENDING, CONFIRMED, REMOVED }

data class Guardian(
    val id: String,
    val name: String,
    val contactInfo: String,
    val status: GuardianStatus
)
