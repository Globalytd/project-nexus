package org.globalytd.projectnexus.feature.authentication.presentation.registration

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
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusSecondaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun RegistrationOptionsRoute(
    onEmailRegister: () -> Unit,
    onPhoneRegister: () -> Unit,
    onBackClick: () -> Unit
) {
    RegistrationOptionsScreen(
        onEmailRegister = onEmailRegister,
        onPhoneRegister = onPhoneRegister,
        onBackClick = onBackClick
    )
}

@Composable
fun RegistrationOptionsScreen(
    onEmailRegister: () -> Unit,
    onPhoneRegister: () -> Unit,
    onBackClick: () -> Unit
) {
    val spacing = LocalNexusSpacing.current
    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Create Account", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.lg))
                Text("How would you like to register?", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(spacing.lg))
                NexusPrimaryButton(text = "Register with Email", onClick = onEmailRegister)
                NexusSecondaryButton(text = "Register with Phone", onClick = onPhoneRegister)
                Spacer(modifier = Modifier.height(spacing.md))
                NexusTextButton(text = "Already have an account? Sign in", onClick = onBackClick)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegistrationOptionsScreenPreview() {
    NexusTheme {
        RegistrationOptionsScreen(onEmailRegister = {}, onPhoneRegister = {}, onBackClick = {})
    }
}
