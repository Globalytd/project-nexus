package org.globalytd.projectnexus.feature.authentication.presentation.passkey

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun PasskeySetupRoute(onSetupComplete: () -> Unit, onSkip: () -> Unit, onBackClick: () -> Unit) {
    PasskeySetupScreen(onSetupComplete = onSetupComplete, onSkip = onSkip, onBackClick = onBackClick)
}

@Composable
fun PasskeySetupScreen(onSetupComplete: () -> Unit, onSkip: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Passkey Setup", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.xl))
                Text(
                    "Sign in faster with a Passkey",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                Text(
                    "Passkeys use your device biometrics or PIN for secure, passwordless sign-in. No passwords to remember.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(spacing.lg))
                NexusPrimaryButton(text = "Create Passkey", onClick = onSetupComplete)
                NexusTextButton(text = "Skip for now", onClick = onSkip)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PasskeySetupScreenPreview() {
    NexusTheme {
        PasskeySetupScreen(onSetupComplete = {}, onSkip = {}, onBackClick = {})
    }
}
