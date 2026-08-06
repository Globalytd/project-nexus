package org.globalytd.projectnexus.feature.authentication.presentation.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.component.NexusPhoneField
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusTextField
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun PhoneRegistrationRoute(onContinue: () -> Unit, onBackClick: () -> Unit) {
    PhoneRegistrationScreen(onContinue = onContinue, onBackClick = onBackClick)
}

@Composable
fun PhoneRegistrationScreen(onContinue: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var countryCode by remember { mutableStateOf("+1") }
    var phoneNumber by remember { mutableStateOf("") }

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Register with Phone", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.md))
                NexusTextField(value = countryCode, onValueChange = { countryCode = it }, label = "Country code")
                NexusPhoneField(value = phoneNumber, onValueChange = { phoneNumber = it })
                Spacer(modifier = Modifier.height(spacing.md))
                NexusPrimaryButton(text = "Continue", onClick = onContinue, enabled = phoneNumber.isNotBlank())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PhoneRegistrationScreenPreview() {
    NexusTheme {
        PhoneRegistrationScreen(onContinue = {}, onBackClick = {})
    }
}
