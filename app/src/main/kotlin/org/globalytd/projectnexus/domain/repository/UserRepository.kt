package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.UserProfile

interface UserRepository {
    suspend fun getUserProfile(userId: String): Result<UserProfile>
    suspend fun updateProfile(profile: UserProfile): Result<UserProfile>
}
