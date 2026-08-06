package org.globalytd.projectnexus.feature.security.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun SecurityRoute(onNavigateToGuardianRecovery: () -> Unit) {
    SecurityScreen(onNavigateToGuardianRecovery = onNavigateToGuardianRecovery)
}

@Composable
fun SecurityScreen(onNavigateToGuardianRecovery: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.md)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(title = "Security")
        listOf("Password", "Passkeys", "Two-Factor Authentication", "Active Sessions", "Security Activity").forEach { item ->
            NexusCard { Text(item, style = MaterialTheme.typography.bodyMedium) }
        }
        NexusCard {
            Column(verticalArrangement = Arrangement.spacedBy(spacing.sm)) {
                Text("Guardian Recovery", style = MaterialTheme.typography.titleSmall)
                Text(
                    "Assign trusted contacts to help recover your account.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                NexusPrimaryButton(text = "Manage Guardians", onClick = onNavigateToGuardianRecovery)
            }
        }
    }
}

@Composable
fun GuardianRecoveryRoute(onBackClick: () -> Unit) {
    GuardianRecoveryScreen(onBackClick = onBackClick)
}

@Composable
fun GuardianRecoveryScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(modifier = Modifier.fillMaxSize()) {
        NexusTopAppBar(title = "Guardian Recovery", onBackClick = onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.md))
            Text(
                "Assign up to 3 trusted contacts as guardians. They can help you recover your account if you lose access.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text("Your Guardians", style = MaterialTheme.typography.titleSmall)
            NexusCard { Text("No guardians added yet.", style = MaterialTheme.typography.bodyMedium) }
            NexusPrimaryButton(text = "Add Guardian (coming soon)", onClick = {}, enabled = false)
            Text("Recovery History", style = MaterialTheme.typography.titleSmall)
            NexusCard { Text("No recovery history.", style = MaterialTheme.typography.bodyMedium) }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SecurityScreenPreview() {
    NexusTheme {
        SecurityScreen(onNavigateToGuardianRecovery = {})
    }
}
