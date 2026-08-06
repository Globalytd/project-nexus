package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.NotificationPreference

interface NotificationRepository {
    suspend fun getPreferences(userId: String): Result<List<NotificationPreference>>
    suspend fun updatePreference(userId: String, preference: NotificationPreference): Result<Unit>
}
