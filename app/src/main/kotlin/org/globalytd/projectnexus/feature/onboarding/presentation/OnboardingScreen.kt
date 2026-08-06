package org.globalytd.projectnexus.feature.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.globalytd.projectnexus.core.designsystem.component.NexusPrimaryButton
import org.globalytd.projectnexus.core.designsystem.component.NexusScreenScaffold
import org.globalytd.projectnexus.core.designsystem.component.NexusTextButton
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusSpacing
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

private data class OnboardingPage(val title: String, val description: String)

private val onboardingPages = listOf(
    OnboardingPage("Learn to Invest", "Access expert-curated courses on stocks, crypto, ETFs, and portfolio strategy."),
    OnboardingPage("Build Your Portfolio", "Track performance, allocate assets, and rebalance with confidence."),
    OnboardingPage("Grow Together", "Join a community of learners and share investment blueprints.")
)

@Composable
fun OnboardingRoute(onFinished: () -> Unit) {
    OnboardingScreen(onFinished = onFinished)
}

@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    val spacing = LocalNexusSpacing.current
    var currentPage by remember { mutableIntStateOf(0) }
    val page = onboardingPages[currentPage]

    NexusScreenScaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.screenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = spacing.md),
                horizontalArrangement = Arrangement.End
            ) {
                NexusTextButton(text = "Skip", onClick = onFinished)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = page.title,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(spacing.md))
            Text(
                text = page.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                onboardingPages.indices.forEach { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == currentPage) 12.dp else 8.dp)
                            .clip(CircleShape)
                            .background(
                                if (index == currentPage) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.outline
                                }
                            )
                    )
                }
            }
            Spacer(modifier = Modifier.height(spacing.lg))
            NexusPrimaryButton(
                text = if (currentPage < onboardingPages.lastIndex) "Continue" else "Get Started",
                onClick = {
                    if (currentPage < onboardingPages.lastIndex) {
                        currentPage++
                    } else {
                        onFinished()
                    }
                }
            )
            Spacer(modifier = Modifier.height(spacing.lg))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    NexusTheme {
        OnboardingScreen(onFinished = {})
    }
}
