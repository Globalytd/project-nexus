package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.VerificationStatus

interface VerificationRepository {
    suspend fun getVerificationStatus(userId: String): Result<VerificationStatus>
    suspend fun submitPersonalInformation(userId: String): Result<Unit>
}
