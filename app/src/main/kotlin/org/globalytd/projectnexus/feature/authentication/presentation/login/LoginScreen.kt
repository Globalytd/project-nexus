package org.globalytd.projectnexus.feature.authentication.presentation.login

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.globalytd.projectnexus.core.designsystem.component.NexusLoadingIndicator
import org.globalytd.projectnexus.core.designsystem.component.NexusPasswordField
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTextField
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun LoginRoute(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onPasskeyClick: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(uiState.loginSuccess) {
        if (uiState.loginSuccess) {
            onLoginSuccess()
        }
    }

    LoginScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
        onRegisterClick = onRegisterClick,
        onForgotPasswordClick = onForgotPasswordClick,
        onPasskeyClick = onPasskeyClick
    )
}

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onAction: (LoginUiAction) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onPasskeyClick: () -> Unit
) {
    val spacing = LocalNexusSpacing.current

    if (uiState.isLoading) {
        NexusLoadingIndicator()
        return
    }

    NexusScreenScaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(spacing.screenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.xxl))
            Text("Welcome back", style = MaterialTheme.typography.headlineMedium)
            Text(
                "Sign in to your Project Nexus account",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(spacing.lg))

            if (uiState.errorMessage != null) {
                Text(
                    text = uiState.errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            NexusTextField(
                value = uiState.email,
                onValueChange = { onAction(LoginUiAction.EmailChanged(it)) },
                label = "Email or phone"
            )

            NexusPasswordField(
                value = uiState.password,
                onValueChange = { onAction(LoginUiAction.PasswordChanged(it)) },
                label = "Password",
                isPasswordVisible = uiState.isPasswordVisible,
                onPasswordVisibilityChange = { onAction(LoginUiAction.PasswordVisibilityChanged) }
            )

            NexusTextButton(text = "Forgot password?", onClick = onForgotPasswordClick)

            NexusPrimaryButton(
                text = "Sign In",
                onClick = { onAction(LoginUiAction.LoginClicked) }
            )

            NexusTextButton(text = "Sign in with passkey", onClick = onPasskeyClick)

            Spacer(modifier = Modifier.height(spacing.md))
            NexusTextButton(text = "Don't have an account? Register", onClick = onRegisterClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    NexusTheme {
        LoginScreen(
            uiState = LoginUiState(),
            onAction = {},
            onRegisterClick = {},
            onForgotPasswordClick = {},
            onPasskeyClick = {}
        )
    }
}
