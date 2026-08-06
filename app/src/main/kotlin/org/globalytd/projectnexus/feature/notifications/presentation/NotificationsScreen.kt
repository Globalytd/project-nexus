package org.globalytd.projectnexus.feature.notifications.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusDivider
import org.globalytd.projectnexus.core.designsystem.component.NexusSectionHeader
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun NotificationsRoute() {
    NotificationsScreen()
}

@Composable
fun NotificationsScreen() {
    val spacing = LocalNexusSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.screenHorizontal),
        verticalArrangement = Arrangement.spacedBy(spacing.md)
    ) {
        Spacer(modifier = Modifier.height(spacing.md))
        NexusSectionHeader(title = "Notifications")
        val notificationItems = listOf(
            "Account Activity" to "Sign-ins, password changes",
            "Portfolio Activity" to "Price alerts, dividends",
            "Security Alerts" to "Suspicious activity, new devices",
            "Learning Reminders" to "Continue your courses",
            "Community Updates" to "Replies, mentions, challenges"
        )
        notificationItems.forEachIndexed { index, (label, desc) ->
            var enabled by remember { mutableStateOf(true) }
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(label, style = MaterialTheme.typography.bodyMedium)
                        Text(desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Switch(checked = enabled, onCheckedChange = { enabled = it })
                }
                if (index < notificationItems.lastIndex) NexusDivider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationsScreenPreview() {
    NexusTheme {
        NotificationsScreen()
    }
}
