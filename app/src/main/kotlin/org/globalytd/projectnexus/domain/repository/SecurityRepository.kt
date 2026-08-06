package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.Guardian
import org.globalytd.projectnexus.domain.model.SecurityEvent

interface SecurityRepository {
    suspend fun getSecurityEvents(userId: String): Result<List<SecurityEvent>>
    suspend fun getGuardians(userId: String): Result<List<Guardian>>
}
