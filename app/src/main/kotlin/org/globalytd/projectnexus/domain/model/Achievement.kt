package org.globalytd.projectnexus.domain.model

data class Achievement(
    val id: String,
    val title: String,
    val description: String,
    val isUnlocked: Boolean,
    val iconDescription: String
)
