package org.globalytd.projectnexus.feature.tax.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusSummaryCard
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun TaxCenterRoute() {
    TaxCenterScreen()
}

@Composable
fun TaxCenterScreen() {
    val spacing = LocalNexusSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.sectionGap)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(title = "Tax Center")

        NexusCard {
            Text(
                "⚠️ DISCLAIMER: This section contains placeholder data only. Nothing here constitutes tax advice. Consult a qualified tax professional for guidance on your situation.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error
            )
        }

        Text("Tax Year 2024", style = MaterialTheme.typography.titleMedium)

        NexusSummaryCard(title = "Short-Term Gains", value = "$1,234.00", subtitle = "Fake data – not tax advice")
        NexusSummaryCard(title = "Long-Term Gains", value = "$3,456.00", subtitle = "Fake data – not tax advice")
        NexusSummaryCard(title = "Total Income", value = "$4,690.00", subtitle = "Fake data – not tax advice")

        NexusSectionHeader(title = "Tax Reports")
        NexusCard {
            Text("Annual Report 2024 – placeholder (document generation coming soon)", style = MaterialTheme.typography.bodyMedium)
        }

        NexusSectionHeader(title = "Transaction History")
        NexusCard { Text("BUY VTI · $450.60 · 2024-01-10", style = MaterialTheme.typography.bodyMedium) }
        NexusCard { Text("DIVIDEND AAPL · $12.30 · 2024-01-05", style = MaterialTheme.typography.bodyMedium) }

        Spacer(modifier = Modifier.height(spacing.xxl))
    }
}

@Preview(showBackground = true)
@Composable
private fun TaxCenterScreenPreview() {
    NexusTheme {
        TaxCenterScreen()
    }
}
