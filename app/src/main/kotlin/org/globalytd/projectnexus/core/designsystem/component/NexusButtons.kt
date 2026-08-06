package org.globalytd.projectnexus.core.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.globalytd.projectnexus.core.designsystem.theme.LocalNexusDimensions
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme

@Composable
fun NexusPrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val dimensions = LocalNexusDimensions.current
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensions.buttonHeight),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun NexusSecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val dimensions = LocalNexusDimensions.current
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensions.buttonHeight),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Composable
fun NexusTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview(showBackground = true)
@Composable
private fun NexusPrimaryButtonPreview() {
    NexusTheme {
        NexusPrimaryButton(text = "Get Started", onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun NexusSecondaryButtonPreview() {
    NexusTheme {
        NexusSecondaryButton(text = "Learn More", onClick = {})
    }
}
