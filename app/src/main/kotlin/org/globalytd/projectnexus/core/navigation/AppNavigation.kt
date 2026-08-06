package org.globalytd.projectnexus.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.globalytd.projectnexus.feature.authentication.navigation.authenticationGraph
import org.globalytd.projectnexus.feature.home.navigation.mainGraph
import org.globalytd.projectnexus.feature.onboarding.navigation.onboardingGraph
import org.globalytd.projectnexus.feature.verification.navigation.verificationGraph

/**
 * Root navigation host for the application.
 * The application always starts at the Welcome screen.
 */
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NexusDestinations.WELCOME,
        modifier = modifier
    ) {
        onboardingGraph(navController)
        authenticationGraph(navController)
        verificationGraph(navController)
        mainGraph(navController)
    }
}
