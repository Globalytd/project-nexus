package org.globalytd.projectnexus.domain.model

data class NotificationPreference(
    val id: String,
    val label: String,
    val description: String,
    val isEnabled: Boolean
)
