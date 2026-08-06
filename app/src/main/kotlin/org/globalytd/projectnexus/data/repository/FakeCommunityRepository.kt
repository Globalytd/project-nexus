package org.globalytd.projectnexus.data.repository

import org.globalytd.projectnexus.domain.model.Achievement
import org.globalytd.projectnexus.domain.model.CommunityPost
import org.globalytd.projectnexus.domain.repository.CommunityRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * FAKE IMPLEMENTATION – demonstration data only.
 */
@Singleton
class FakeCommunityRepository @Inject constructor() : CommunityRepository {

    override suspend fun getFeedPosts(): Result<List<CommunityPost>> =
        Result.success(
            listOf(
                CommunityPost("p1", "Alice K.", "Just rebalanced my portfolio – feeling confident about the ETF allocation! 📈", 42, 8, "2024-01-15"),
                CommunityPost("p2", "Bob M.", "Completed the Risk Management course. Highly recommend it.", 31, 5, "2024-01-14"),
                CommunityPost("p3", "Carol N.", "Anyone else watching the crypto market this week?", 18, 12, "2024-01-13")
            )
        )

    override suspend fun getAchievements(userId: String): Result<List<Achievement>> =
        Result.success(
            listOf(
                Achievement("a1", "First Investment", "Made your first investment", isUnlocked = true, "trophy"),
                Achievement("a2", "Diversified", "Hold 5 different assets", isUnlocked = true, "shield"),
                Achievement("a3", "Scholar", "Complete 10 lessons", isUnlocked = false, "book"),
                Achievement("a4", "Community Star", "Get 100 likes", isUnlocked = false, "star")
            )
        )
}
