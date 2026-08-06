package org.globalytd.projectnexus.feature.settings.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.globalytd.projectnexus.core.designsystem.component.NexusAvatar
import org.globalytd.projectnexus.core.designsystem.component.NexusCard
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.component.NexusStatusChip
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusGreen
import org.globalytd.projectnexus.core.designsystem.component.NexusSecondaryButton
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun ProfileRoute(onBackClick: () -> Unit) {
    ProfileScreen(onBackClick = onBackClick)
}

@Composable
fun ProfileScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(modifier = Modifier.fillMaxSize()) {
        NexusTopAppBar(title = "Profile", onBackClick = onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.lg))
            NexusAvatar(initials = "DU", size = 80.dp)
            Text("Demo User", style = MaterialTheme.typography.headlineSmall)
            Text(
                "demo@projectnexus.app",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            NexusStatusChip(label = "Identity Verified", color = NexusGreen)
            NexusPrimaryButton(text = "Edit Profile (coming soon)", onClick = {}, enabled = false)
        }
    }
}

@Composable
fun SettingsRoute(onBackClick: () -> Unit) {
    SettingsScreen(onBackClick = onBackClick)
}

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    Column(modifier = Modifier.fillMaxSize()) {
        NexusTopAppBar(title = "Settings", onBackClick = onBackClick)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.md))
            NexusSectionHeader(title = "Account")
            listOf("Personal Information", "Account Settings").forEach { item ->
                NexusCard { Text(item, style = MaterialTheme.typography.bodyMedium) }
            }
            NexusSectionHeader(title = "Preferences")
            listOf("Appearance", "Accessibility", "Privacy").forEach { item ->
                NexusCard { Text(item, style = MaterialTheme.typography.bodyMedium) }
            }
            NexusSectionHeader(title = "About")
            listOf("Legal", "Terms of Service", "Privacy Policy").forEach { item ->
                NexusCard { Text(item, style = MaterialTheme.typography.bodyMedium) }
            }
            Spacer(modifier = Modifier.height(spacing.md))
            NexusSecondaryButton(text = "Sign Out", onClick = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview() {
    NexusTheme {
        SettingsScreen(onBackClick = {})
    }
}
