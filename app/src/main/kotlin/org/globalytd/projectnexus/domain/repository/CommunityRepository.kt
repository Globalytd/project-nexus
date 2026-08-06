package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.Achievement
import org.globalytd.projectnexus.domain.model.CommunityPost

interface CommunityRepository {
    suspend fun getFeedPosts(): Result<List<CommunityPost>>
    suspend fun getAchievements(userId: String): Result<List<Achievement>>
}
