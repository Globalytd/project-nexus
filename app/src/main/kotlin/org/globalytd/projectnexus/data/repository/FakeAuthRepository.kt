package org.globalytd.projectnexus.data.repository

import org.globalytd.projectnexus.domain.model.User
import org.globalytd.projectnexus.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * FAKE IMPLEMENTATION – for demonstration and development only.
 * Simulates authentication without a real backend.
 * Replace with a real implementation before release.
 */
@Singleton
class FakeAuthRepository @Inject constructor() : AuthRepository {

    private val fakeUser = User(
        id = "demo-user-001",
        email = "demo@projectnexus.app",
        displayName = "Demo User",
        isEmailVerified = true
    )

    override suspend fun login(email: String, password: String): Result<User> {
        // Fake: always succeeds for any non-empty credentials
        return if (email.isNotBlank() && password.isNotBlank()) {
            Result.success(fakeUser)
        } else {
            Result.failure(Exception("Email and password are required"))
        }
    }

    override suspend fun register(email: String, password: String, displayName: String): Result<User> {
        return Result.success(fakeUser.copy(email = email, displayName = displayName))
    }

    override suspend fun logout() {
        // Fake: no-op
    }

    override suspend fun getCurrentUser(): User? = fakeUser

    override suspend fun sendPasswordReset(email: String): Result<Unit> {
        return Result.success(Unit)
    }
}
