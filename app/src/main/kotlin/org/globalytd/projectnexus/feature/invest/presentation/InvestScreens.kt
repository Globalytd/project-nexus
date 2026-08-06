package org.globalytd.projectnexus.feature.invest.presentation

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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusPercentageField
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun InvestRoute(onNavigateToAllocation: () -> Unit, onNavigateToRebalancing: () -> Unit) {
    InvestScreen(onNavigateToAllocation = onNavigateToAllocation, onNavigateToRebalancing = onNavigateToRebalancing)
}

@Composable
fun InvestScreen(onNavigateToAllocation: () -> Unit, onNavigateToRebalancing: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.md)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(title = "Invest")
        listOf(
            "Brokerage Account" to "Open and manage a brokerage account",
            "Crypto Account" to "Buy, sell, and hold cryptocurrencies",
            "Portfolio Allocation" to "Set your target asset allocation",
            "Recurring Investment" to "Automate regular investments",
            "Rebalancing" to "Keep your portfolio on target",
            "Market Information" to "Browse markets and assets"
        ).forEach { (title, desc) ->
            NexusCard {
                Text(title, style = MaterialTheme.typography.titleSmall)
                Text(
                    desc,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        NexusTextButton(text = "Edit Allocation", onClick = onNavigateToAllocation)
        NexusTextButton(text = "Set Rebalancing", onClick = onNavigateToRebalancing)
        Spacer(modifier = Modifier.height(spacing.xxl))
    }
}

@Composable
fun AllocationRoute(onBackClick: () -> Unit) {
    AllocationScreen(onBackClick = onBackClick)
}

@Composable
fun AllocationScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var etf by remember { mutableStateOf("40") }
    var stocks by remember { mutableStateOf("30") }
    var crypto by remember { mutableStateOf("15") }
    var bonds by remember { mutableStateOf("10") }
    var cash by remember { mutableStateOf("5") }

    val total = listOf(etf, stocks, crypto, bonds, cash).sumOf { it.toIntOrNull() ?: 0 }
    val isValid = total == 100

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Portfolio Allocation", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(spacing.screenHorizontal),
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                NexusPercentageField(value = etf, onValueChange = { etf = it }, label = "ETFs", modifier = Modifier.fillMaxWidth())
                NexusPercentageField(value = stocks, onValueChange = { stocks = it }, label = "Stocks", modifier = Modifier.fillMaxWidth())
                NexusPercentageField(value = crypto, onValueChange = { crypto = it }, label = "Crypto", modifier = Modifier.fillMaxWidth())
                NexusPercentageField(value = bonds, onValueChange = { bonds = it }, label = "Bonds", modifier = Modifier.fillMaxWidth())
                NexusPercentageField(value = cash, onValueChange = { cash = it }, label = "Cash", modifier = Modifier.fillMaxWidth())

                Text(
                    text = "Total: $total%${if (!isValid) " – must equal 100%" else " ✓"}",
                    color = if (isValid) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
                NexusPrimaryButton(text = "Save Allocation", onClick = {}, enabled = isValid)
            }
        }
    }
}

@Composable
fun RebalancingRoute(onBackClick: () -> Unit) {
    RebalancingScreen(onBackClick = onBackClick)
}

@Composable
fun RebalancingScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    val options = listOf("Quarterly", "Semi-Annual", "Annual", "Manual")
    var selected by remember { mutableStateOf("Quarterly") }

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Rebalancing Schedule", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.md))
                Text("Select rebalancing frequency", style = MaterialTheme.typography.titleMedium)
                options.forEach { option ->
                    NexusCard {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = option == selected,
                                onClick = { selected = option }
                            )
                            Text(option, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
                Text(
                    "Current schedule: $selected",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                NexusPrimaryButton(text = "Save Schedule", onClick = {})
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InvestScreenPreview() {
    NexusTheme {
        InvestScreen(onNavigateToAllocation = {}, onNavigateToRebalancing = {})
    }
}
