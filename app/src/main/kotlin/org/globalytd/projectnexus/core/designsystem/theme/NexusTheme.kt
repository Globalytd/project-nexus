package org.globalytd.projectnexus.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LightColorScheme = lightColorScheme(
    primary = NexusBlue,
    onPrimary = NexusWhite,
    primaryContainer = NexusBlueLight,
    onPrimaryContainer = NexusBlueDark,
    secondary = NexusGray600,
    onSecondary = NexusWhite,
    secondaryContainer = NexusGray100,
    onSecondaryContainer = NexusGray800,
    background = NexusGray50,
    onBackground = NexusGray900,
    surface = NexusWhite,
    onSurface = NexusGray900,
    surfaceVariant = NexusGray100,
    onSurfaceVariant = NexusGray600,
    outline = NexusGray200,
    error = NexusRed,
    onError = NexusWhite,
)

private val DarkColorScheme = darkColorScheme(
    primary = NexusBlueLight,
    onPrimary = NexusNavy,
    primaryContainer = NexusBlueDark,
    onPrimaryContainer = NexusBlueLight,
    secondary = NexusGray400,
    onSecondary = NexusGray900,
    secondaryContainer = NexusGray800,
    onSecondaryContainer = NexusGray100,
    background = NexusGray900,
    onBackground = NexusGray50,
    surface = NexusGray800,
    onSurface = NexusGray50,
    surfaceVariant = NexusGray800,
    onSurfaceVariant = NexusGray400,
    outline = NexusGray600,
    error = NexusRed,
    onError = NexusWhite,
)

/**
 * NexusTheme wraps all Project Nexus screens.
 * It provides the Material 3 color scheme, typography, shapes,
 * and custom spacing / dimension tokens through CompositionLocals.
 */
@Composable
fun NexusTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalNexusSpacing provides NexusSpacing(),
        LocalNexusDimensions provides NexusDimensions(),
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = NexusTypography,
            shapes = NexusShapes,
            content = content
        )
    }
}

/** Convenience accessors inside Composables */
object NexusThemeTokens {
    val spacing: NexusSpacing
        @Composable get() = LocalNexusSpacing.current
    val dimensions: NexusDimensions
        @Composable get() = LocalNexusDimensions.current
}
