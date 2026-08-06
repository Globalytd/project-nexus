package org.globalytd.projectnexus.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * NexusDimensions provides reusable size tokens.
 */
@Immutable
data class NexusDimensions(
    val buttonHeight: Dp = 52.dp,
    val textFieldHeight: Dp = 56.dp,
    val cardElevation: Dp = 2.dp,
    val iconSizeMd: Dp = 24.dp,
    val iconSizeLg: Dp = 32.dp,
    val avatarSizeMd: Dp = 48.dp,
    val avatarSizeLg: Dp = 80.dp,
    val bottomBarHeight: Dp = 80.dp,
    val minTouchTarget: Dp = 48.dp,
)

val LocalNexusDimensions = staticCompositionLocalOf { NexusDimensions() }
