package org.globalytd.projectnexus.feature.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusChartPlaceholder
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusSummaryCard
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun HomeRoute(
    onNavigateToPortfolio: () -> Unit,
    onNavigateToInvest: () -> Unit
) {
    HomeScreen(
        onNavigateToPortfolio = onNavigateToPortfolio,
        onNavigateToInvest = onNavigateToInvest
    )
}

@Composable
fun HomeScreen(
    onNavigateToPortfolio: () -> Unit,
    onNavigateToInvest: () -> Unit
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
        Text("Good morning, Demo User", style = MaterialTheme.typography.headlineSmall)
        Text(
            "⚠️ All data shown is fake demonstration data.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacing.md)) {
            NexusSummaryCard(
                title = "Total Value",
                value = "$12,345.67",
                subtitle = "+$234.50 (1.94%)",
                modifier = Modifier.weight(1f)
            )
            NexusSummaryCard(
                title = "Cash Available",
                value = "$1,500.00",
                modifier = Modifier.weight(1f)
            )
        }

        NexusSectionHeader(
            title = "Portfolio Performance",
            action = { NexusTextButton(text = "View Portfolio", onClick = onNavigateToPortfolio) }
        )
        NexusChartPlaceholder()

        NexusSectionHeader(title = "Allocation Summary")
        NexusCard {
            Text(
                "ETF 40% · Stocks 30% · Crypto 15% · Bonds 10% · Cash 5%",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        NexusSectionHeader(title = "Recent Activity")
        NexusCard {
            Column(verticalArrangement = Arrangement.spacedBy(spacing.sm)) {
                Text("BUY VTI · $450.60", style = MaterialTheme.typography.bodyMedium)
                Text("DIVIDEND AAPL · $12.30", style = MaterialTheme.typography.bodyMedium)
            }
        }

        NexusSectionHeader(
            title = "Learning Recommendation",
            action = { NexusTextButton(text = "Invest Hub", onClick = onNavigateToInvest) }
        )
        NexusCard {
            Text("Continue: Risk Management – Lesson 2", style = MaterialTheme.typography.bodyMedium)
        }

        NexusSectionHeader(title = "Community Highlight")
        NexusCard {
            Text(
                "Alice K. just shared a new Blueprint: 'Balanced Growth 2024' 🚀",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(spacing.xxl))
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    NexusTheme {
        HomeScreen(onNavigateToPortfolio = {}, onNavigateToInvest = {})
    }
}
