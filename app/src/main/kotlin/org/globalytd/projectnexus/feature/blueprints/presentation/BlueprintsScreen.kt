package org.globalytd.projectnexus.feature.blueprints.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun BlueprintListRoute() {
    BlueprintListScreen()
}

@Composable
fun BlueprintListScreen() {
    val spacing = LocalNexusSpacing.current
    val tabs = listOf("My Blueprints", "Community", "Saved")
    var selectedTab by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.screenHorizontal)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(title = "Blueprints")
        ScrollableTabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(selected = index == selectedTab, onClick = { selectedTab = index }, text = { Text(title) })
            }
        }
        Spacer(modifier = Modifier.height(spacing.md))
        Column(verticalArrangement = Arrangement.spacedBy(spacing.md)) {
            NexusCard {
                Text("Balanced Growth 2024", style = MaterialTheme.typography.titleSmall)
                Text(
                    "by Alice K. · Moderate risk · ETF 40% / Stocks 30% / Crypto 15% / Bonds 10% / Cash 5%",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            NexusCard {
                Text("Conservative Income", style = MaterialTheme.typography.titleSmall)
                Text(
                    "by Bob M. · Conservative risk · Bonds 50% / ETF 30% / Cash 20%",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BlueprintListScreenPreview() {
    NexusTheme {
        BlueprintListScreen()
    }
}
