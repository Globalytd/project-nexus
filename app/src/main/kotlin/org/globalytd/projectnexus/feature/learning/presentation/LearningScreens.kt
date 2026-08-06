package org.globalytd.projectnexus.feature.learning.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun LearningHomeRoute() {
    LearningHomeScreen()
}

@Composable
fun LearningHomeScreen() {
    val spacing = LocalNexusSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.md)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(title = "Learn")
        listOf(
            Triple("Investment Basics", "5 lessons", 0.4f),
            Triple("Crypto Education", "4 lessons", 0.0f),
            Triple("Portfolio Diversification", "3 lessons", 0.0f),
            Triple("Risk Management", "4 lessons", 0.25f),
            Triple("Personal Finance", "6 lessons", 0.1f)
        ).forEach { (title, desc, progress) ->
            NexusCard {
                Text(title, style = MaterialTheme.typography.titleSmall)
                Text(desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                if (progress > 0f) {
                    Spacer(modifier = Modifier.height(spacing.xs))
                    LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth())
                }
            }
        }
        Spacer(modifier = Modifier.height(spacing.xxl))
    }
}

@Preview(showBackground = true)
@Composable
private fun LearningHomeScreenPreview() {
    NexusTheme {
        LearningHomeScreen()
    }
}
