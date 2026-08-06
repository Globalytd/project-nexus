package org.globalytd.projectnexus.feature.portfolio.presentation

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
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusChartPlaceholder
import org.globalytd.projectnexus.core.designsystem.component.NexusDivider
import org.globalytd.projectnexus.core.designsystem.component.NexusListItem
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusSummaryCard
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun PortfolioRoute(onNavigateToAllocation: () -> Unit, onNavigateToRebalancing: () -> Unit) {
    PortfolioScreen(onNavigateToAllocation = onNavigateToAllocation, onNavigateToRebalancing = onNavigateToRebalancing)
}

@Composable
fun PortfolioScreen(onNavigateToAllocation: () -> Unit, onNavigateToRebalancing: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    val periods = listOf("1W", "1M", "3M", "1Y", "All")
    var selectedPeriod by remember { mutableStateOf("1M") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.sectionGap)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSummaryCard(
            title = "Total Portfolio Value",
            value = "$12,345.67",
            subtitle = "⚠️ Fake demonstration data"
        )

        Row(horizontalArrangement = Arrangement.spacedBy(spacing.sm)) {
            periods.forEach { period ->
                FilterChip(
                    selected = period == selectedPeriod,
                    onClick = { selectedPeriod = period },
                    label = { Text(period) }
                )
            }
        }

        NexusChartPlaceholder(label = "Performance chart placeholder")
        NexusChartPlaceholder(label = "Asset allocation chart placeholder")

        NexusSectionHeader(
            title = "Holdings",
            action = { NexusTextButton(text = "Allocation", onClick = onNavigateToAllocation) }
        )
        NexusCard {
            Column {
                Text("Stocks", style = MaterialTheme.typography.titleSmall)
                NexusDivider()
                NexusListItem(title = "AAPL – Apple Inc.", subtitle = "10 shares · $1,785.00", trailing = { Text("+8.84%") })
                NexusListItem(title = "MSFT – Microsoft", subtitle = "5 shares · $1,875.00", trailing = { Text("+10.29%") })
                NexusDivider()
                Text("ETFs", style = MaterialTheme.typography.titleSmall)
                NexusDivider()
                NexusListItem(title = "VTI – Vanguard Total Market", subtitle = "20 shares · $4,506.00", trailing = { Text("+9.74%") })
                NexusDivider()
                Text("Crypto", style = MaterialTheme.typography.titleSmall)
                NexusDivider()
                NexusListItem(title = "BTC – Bitcoin", subtitle = "0.05 BTC · $2,100.00", trailing = { Text("-2.33%") })
                NexusDivider()
                Text("Cash", style = MaterialTheme.typography.titleSmall)
                NexusDivider()
                NexusListItem(title = "USD Cash", subtitle = "Available", trailing = { Text("$1,500.00") })
            }
        }
        NexusTextButton(text = "Manage Rebalancing", onClick = onNavigateToRebalancing)
        Spacer(modifier = Modifier.height(spacing.xxl))
    }
}

@Preview(showBackground = true)
@Composable
private fun PortfolioScreenPreview() {
    NexusTheme {
        PortfolioScreen(onNavigateToAllocation = {}, onNavigateToRebalancing = {})
    }
}
