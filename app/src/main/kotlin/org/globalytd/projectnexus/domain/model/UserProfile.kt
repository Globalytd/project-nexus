package org.globalytd.projectnexus.domain.model

data class UserProfile(
    val userId: String,
    val fullName: String,
    val bio: String = "",
    val avatarInitials: String,
    val verificationStatus: VerificationStatus = VerificationStatus.NOT_STARTED
)
