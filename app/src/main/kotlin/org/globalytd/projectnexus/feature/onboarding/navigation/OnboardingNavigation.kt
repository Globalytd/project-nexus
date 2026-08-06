package org.globalytd.projectnexus.feature.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.globalytd.projectnexus.core.navigation.NexusDestinations
import org.globalytd.projectnexus.feature.onboarding.presentation.OnboardingRoute
import org.globalytd.projectnexus.feature.onboarding.presentation.WelcomeRoute

fun NavGraphBuilder.onboardingGraph(navController: NavHostController) {
    composable(NexusDestinations.WELCOME) {
        WelcomeRoute(
            onGetStarted = { navController.navigate(NexusDestinations.ONBOARDING) },
            onSignIn = { navController.navigate(NexusDestinations.LOGIN) }
        )
    }
    composable(NexusDestinations.ONBOARDING) {
        OnboardingRoute(
            onFinished = { navController.navigate(NexusDestinations.LOGIN) }
        )
    }
}
