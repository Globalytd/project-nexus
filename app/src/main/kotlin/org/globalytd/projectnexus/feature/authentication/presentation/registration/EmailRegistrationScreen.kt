package org.globalytd.projectnexus.feature.authentication.presentation.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusPasswordField
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusTextField
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun EmailRegistrationRoute(onRegistrationSuccess: () -> Unit, onBackClick: () -> Unit) {
    EmailRegistrationScreen(onRegistrationSuccess = onRegistrationSuccess, onBackClick = onBackClick)
}

@Composable
fun EmailRegistrationScreen(onRegistrationSuccess: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var termsAccepted by remember { mutableStateOf(false) }

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Register with Email", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(spacing.screenHorizontal),
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.md))
                NexusTextField(value = fullName, onValueChange = { fullName = it }, label = "Full name")
                NexusTextField(value = email, onValueChange = { email = it }, label = "Email address")
                NexusPasswordField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Password",
                    isPasswordVisible = passwordVisible,
                    onPasswordVisibilityChange = { passwordVisible = !passwordVisible }
                )
                NexusPasswordField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = "Confirm password",
                    isPasswordVisible = passwordVisible,
                    onPasswordVisibilityChange = { passwordVisible = !passwordVisible }
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = termsAccepted, onCheckedChange = { termsAccepted = it })
                    Text("I accept the terms and conditions", style = MaterialTheme.typography.bodyMedium)
                }
                NexusPrimaryButton(
                    text = "Continue",
                    onClick = onRegistrationSuccess,
                    enabled = termsAccepted && fullName.isNotBlank() && email.isNotBlank() &&
                            password.isNotBlank() && password == confirmPassword
                )
                Spacer(modifier = Modifier.height(spacing.md))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EmailRegistrationScreenPreview() {
    NexusTheme {
        EmailRegistrationScreen(onRegistrationSuccess = {}, onBackClick = {})
    }
}
