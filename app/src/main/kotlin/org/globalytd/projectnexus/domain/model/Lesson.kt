package org.globalytd.projectnexus.domain.model

data class Lesson(
    val id: String,
    val categoryId: String,
    val title: String,
    val content: String,
    val isCompleted: Boolean = false,
    val durationMinutes: Int
)
