package org.globalytd.projectnexus.domain.model

data class SecurityEvent(
    val id: String,
    val description: String,
    val timestamp: String,
    val deviceInfo: String
)
