package org.globalytd.projectnexus.feature.community.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusAvatar
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun CommunityFeedRoute(
    onNavigateToLeaderboard: () -> Unit,
    onNavigateToAchievements: () -> Unit
) {
    CommunityFeedScreen(
        onNavigateToLeaderboard = onNavigateToLeaderboard,
        onNavigateToAchievements = onNavigateToAchievements
    )
}

@Composable
fun CommunityFeedScreen(
    onNavigateToLeaderboard: () -> Unit,
    onNavigateToAchievements: () -> Unit
) {
    val spacing = LocalNexusSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.sectionGap)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(
            title = "Community",
            action = {
                Row(horizontalArrangement = Arrangement.spacedBy(spacing.sm)) {
                    NexusTextButton(text = "Leaderboard", onClick = onNavigateToLeaderboard)
                    NexusTextButton(text = "Achievements", onClick = onNavigateToAchievements)
                }
            }
        )

        NexusCard {
            Column(verticalArrangement = Arrangement.spacedBy(spacing.sm)) {
                Row(horizontalArrangement = Arrangement.spacedBy(spacing.sm)) {
                    NexusAvatar(initials = "AK")
                    Column {
                        Text("Alice K.", style = MaterialTheme.typography.titleSmall)
                        Text("Just rebalanced my portfolio 📈", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            "42 likes · 8 comments",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        NexusCard {
            Column(verticalArrangement = Arrangement.spacedBy(spacing.sm)) {
                Row(horizontalArrangement = Arrangement.spacedBy(spacing.sm)) {
                    NexusAvatar(initials = "BM")
                    Column {
                        Text("Bob M.", style = MaterialTheme.typography.titleSmall)
                        Text("Completed the Risk Management course. Highly recommend!", style = MaterialTheme.typography.bodyMedium)
                        Text(
                            "31 likes · 5 comments",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        NexusCard {
            Text("Learning Group", style = MaterialTheme.typography.titleSmall)
            Text(
                "Investment Basics – 24 members active this week",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        NexusCard {
            Text("Community Challenge", style = MaterialTheme.typography.titleSmall)
            Text(
                "Complete 5 lessons this month to earn the Scholar badge 🏆",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(modifier = Modifier.height(spacing.xxl))
    }
}

@Composable
fun LeaderboardRoute(onBackClick: () -> Unit) {
    LeaderboardScreen(onBackClick = onBackClick)
}

@Composable
fun LeaderboardScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(modifier = Modifier.fillMaxSize()) {
        NexusTopAppBar(title = "Leaderboard", onBackClick = onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.md))
            listOf(
                Triple(1, "Alice K.", "2,450 pts"),
                Triple(2, "Carol N.", "1,980 pts"),
                Triple(3, "Demo User", "1,200 pts")
            ).forEach { (rank, name, points) ->
                NexusCard {
                    Row(horizontalArrangement = Arrangement.spacedBy(spacing.md)) {
                        Text("#$rank", style = MaterialTheme.typography.titleMedium)
                        Text(name, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                        Text(points, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
fun AchievementsRoute(onBackClick: () -> Unit) {
    AchievementsScreen(onBackClick = onBackClick)
}

@Composable
fun AchievementsScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(modifier = Modifier.fillMaxSize()) {
        NexusTopAppBar(title = "Achievements", onBackClick = onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.md))
            NexusCard {
                Text("🏆 First Investment – Unlocked", style = MaterialTheme.typography.bodyMedium)
            }
            NexusCard {
                Text("🛡️ Diversified – Unlocked", style = MaterialTheme.typography.bodyMedium)
            }
            NexusCard {
                Text(
                    "📖 Scholar – Locked (complete 10 lessons)",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            NexusCard {
                Text(
                    "⭐ Community Star – Locked (get 100 likes)",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CommunityFeedPreview() {
    NexusTheme {
        CommunityFeedScreen(onNavigateToLeaderboard = {}, onNavigateToAchievements = {})
    }
}
