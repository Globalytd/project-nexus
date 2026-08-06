package org.globalytd.projectnexus.domain.model

/**
 * Core user identity model.
 * Does not contain Android framework classes.
 */
data class User(
    val id: String,
    val email: String,
    val displayName: String,
    val phoneNumber: String? = null,
    val isEmailVerified: Boolean = false,
    val isPhoneVerified: Boolean = false
)
