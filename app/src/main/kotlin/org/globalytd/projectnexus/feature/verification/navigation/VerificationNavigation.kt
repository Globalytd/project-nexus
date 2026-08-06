package org.globalytd.projectnexus.feature.verification.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.globalytd.projectnexus.core.navigation.NexusDestinations
import org.globalytd.projectnexus.feature.verification.presentation.DocumentVerificationRoute
import org.globalytd.projectnexus.feature.verification.presentation.LivenessCheckRoute
import org.globalytd.projectnexus.feature.verification.presentation.PersonalInformationRoute
import org.globalytd.projectnexus.feature.verification.presentation.VerificationIntroductionRoute
import org.globalytd.projectnexus.feature.verification.presentation.VerificationStatusRoute

fun NavGraphBuilder.verificationGraph(navController: NavHostController) {
    composable(NexusDestinations.VERIFICATION_INTRO) {
        VerificationIntroductionRoute(
            onBeginVerification = { navController.navigate(NexusDestinations.PERSONAL_INFORMATION) },
            onSkip = { navController.navigate(NexusDestinations.MAIN) }
        )
    }
    composable(NexusDestinations.PERSONAL_INFORMATION) {
        PersonalInformationRoute(
            onContinue = { navController.navigate(NexusDestinations.DOCUMENT_VERIFICATION) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.DOCUMENT_VERIFICATION) {
        DocumentVerificationRoute(
            onContinue = { navController.navigate(NexusDestinations.LIVENESS_CHECK) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.LIVENESS_CHECK) {
        LivenessCheckRoute(
            onCheckComplete = { navController.navigate(NexusDestinations.VERIFICATION_STATUS) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.VERIFICATION_STATUS) {
        VerificationStatusRoute(
            onContinue = { navController.navigate(NexusDestinations.MAIN) }
        )
    }
}
