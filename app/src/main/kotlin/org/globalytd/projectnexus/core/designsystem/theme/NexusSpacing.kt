package org.globalytd.projectnexus.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * NexusSpacing provides consistent spacing tokens for the design system.
 * Access via LocalNexusSpacing.current inside Composables.
 */
@Immutable
data class NexusSpacing(
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 16.dp,
    val lg: Dp = 24.dp,
    val xl: Dp = 32.dp,
    val xxl: Dp = 48.dp,
    val screenHorizontal: Dp = 20.dp,
    val cardPadding: Dp = 16.dp,
    val sectionGap: Dp = 24.dp,
)

val LocalNexusSpacing = staticCompositionLocalOf { NexusSpacing() }
