package org.globalytd.projectnexus.feature.authentication.presentation.twofactor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTextField
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun TwoFactorAuthRoute(onVerified: () -> Unit, onBackClick: () -> Unit) {
    TwoFactorAuthScreen(onVerified = onVerified, onBackClick = onBackClick)
}

@Composable
fun TwoFactorAuthScreen(onVerified: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var code by remember { mutableStateOf("") }

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Two-Factor Authentication", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.lg))
                Text(
                    "Enter your 6-digit code",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                Text(
                    "We sent a verification code to your registered device.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                NexusTextField(
                    value = code,
                    onValueChange = { if (it.length <= 6) code = it },
                    label = "6-digit code"
                )
                NexusTextButton(text = "Resend code", onClick = {})
                NexusPrimaryButton(text = "Verify", onClick = onVerified, enabled = code.length == 6)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TwoFactorAuthScreenPreview() {
    NexusTheme {
        TwoFactorAuthScreen(onVerified = {}, onBackClick = {})
    }
}
