package org.globalytd.projectnexus.domain.model

data class CommunityPost(
    val id: String,
    val authorName: String,
    val content: String,
    val likesCount: Int,
    val commentsCount: Int,
    val timestamp: String
)
