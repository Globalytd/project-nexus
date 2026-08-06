package org.globalytd.projectnexus.feature.verification.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
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
import org.globalytd.projectnexus.core.designsystem.component.NexusSecondaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusStatusChip
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.component.NexusTextField
import org.globalytd.projectnexus.core.designsystem.component.NexusTopAppBar
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusGreen
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun VerificationIntroductionRoute(onBeginVerification: () -> Unit, onSkip: () -> Unit) {
    VerificationIntroductionScreen(onBeginVerification = onBeginVerification, onSkip = onSkip)
}

@Composable
fun VerificationIntroductionScreen(onBeginVerification: () -> Unit, onSkip: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    NexusScreenScaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.xl))
            Text(
                "Verify Your Identity",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Text(
                "To open an investment account and comply with regulations, we need to verify your identity. This takes about 5 minutes.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Text("You will need:", style = MaterialTheme.typography.titleSmall)
            listOf(
                "Government-issued photo ID",
                "A few minutes of your time",
                "Good lighting for liveness check"
            ).forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(spacing.sm)
                ) {
                    Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = NexusGreen)
                    Text(item, style = MaterialTheme.typography.bodyMedium)
                }
            }
            Text(
                "Estimated time: ~5 minutes",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.weight(1f))
            NexusPrimaryButton(text = "Begin Verification", onClick = onBeginVerification)
            NexusTextButton(text = "Skip for now", onClick = onSkip)
            Spacer(modifier = Modifier.height(spacing.md))
        }
    }
}

@Composable
fun PersonalInformationRoute(onContinue: () -> Unit, onBackClick: () -> Unit) {
    PersonalInformationScreen(onContinue = onContinue, onBackClick = onBackClick)
}

@Composable
fun PersonalInformationScreen(onContinue: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var legalName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Personal Information", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(spacing.screenHorizontal),
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.md))
                NexusTextField(value = legalName, onValueChange = { legalName = it }, label = "Legal name")
                NexusTextField(value = dateOfBirth, onValueChange = { dateOfBirth = it }, label = "Date of birth (YYYY-MM-DD)")
                NexusTextField(value = address, onValueChange = { address = it }, label = "Address")
                NexusTextField(value = country, onValueChange = { country = it }, label = "Country")
                Spacer(modifier = Modifier.height(spacing.md))
                NexusPrimaryButton(text = "Continue", onClick = onContinue)
            }
        }
    }
}

@Composable
fun DocumentVerificationRoute(onContinue: () -> Unit, onBackClick: () -> Unit) {
    DocumentVerificationScreen(onContinue = onContinue, onBackClick = onBackClick)
}

@Composable
fun DocumentVerificationScreen(onContinue: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var documentType by remember { mutableStateOf("Passport") }

    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Document Verification", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.md))
                NexusTextField(value = documentType, onValueChange = { documentType = it }, label = "Document type")
                NexusSecondaryButton(text = "Upload front of document (coming soon)", onClick = {}, enabled = false)
                NexusSecondaryButton(text = "Upload back of document (coming soon)", onClick = {}, enabled = false)
                Text(
                    "Camera and file access will be implemented in a future release.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.weight(1f))
                NexusPrimaryButton(text = "Continue", onClick = onContinue)
            }
        }
    }
}

@Composable
fun LivenessCheckRoute(onCheckComplete: () -> Unit, onBackClick: () -> Unit) {
    LivenessCheckScreen(onCheckComplete = onCheckComplete, onBackClick = onBackClick)
}

@Composable
fun LivenessCheckScreen(onCheckComplete: () -> Unit, onBackClick: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    NexusScreenScaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NexusTopAppBar(title = "Liveness Check", onBackClick = onBackClick)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing.screenHorizontal),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(spacing.md)
            ) {
                Spacer(modifier = Modifier.height(spacing.xl))
                Text(
                    "Face Scan Placeholder",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                Text(
                    "The real liveness check will access the camera. For now this is a placeholder. Camera access will be implemented in a future release.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))
                NexusPrimaryButton(text = "Start Check (Placeholder)", onClick = onCheckComplete)
            }
        }
    }
}

@Composable
fun VerificationStatusRoute(onContinue: () -> Unit) {
    VerificationStatusScreen(onContinue = onContinue)
}

@Composable
fun VerificationStatusScreen(onContinue: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    NexusScreenScaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(spacing.md)
        ) {
            Spacer(modifier = Modifier.height(spacing.xl))
            Text(
                "Verification Submitted",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            NexusStatusChip(label = "Pending Review", color = NexusGreen)
            Text(
                "Your documents have been submitted for review. You will be notified when verification is complete.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            NexusPrimaryButton(text = "Continue to Home", onClick = onContinue)
            Spacer(modifier = Modifier.height(spacing.md))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VerificationIntroductionPreview() {
    NexusTheme {
        VerificationIntroductionScreen(onBeginVerification = {}, onSkip = {})
    }
}
