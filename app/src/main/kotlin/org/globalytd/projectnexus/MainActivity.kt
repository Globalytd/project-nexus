package org.globalytd.projectnexus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import org.globalytd.projectnexus.core.designsystem.theme.NexusTheme
import org.globalytd.projectnexus.core.navigation.AppNavigation

/**
 * Single-activity entry point for Project Nexus.
 * Navigation is handled entirely by Jetpack Compose Navigation.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NexusTheme {
                AppNavigation()
            }
        }
    }
}
