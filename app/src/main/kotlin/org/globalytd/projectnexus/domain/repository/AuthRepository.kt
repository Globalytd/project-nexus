package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.User

/** Contract for authentication operations. Real implementation added later. */
interface AuthRepository {
    suspend fun login(email: String, password: String): Result<User>
    suspend fun register(email: String, password: String, displayName: String): Result<User>
    suspend fun logout()
    suspend fun getCurrentUser(): User?
    suspend fun sendPasswordReset(email: String): Result<Unit>
}
