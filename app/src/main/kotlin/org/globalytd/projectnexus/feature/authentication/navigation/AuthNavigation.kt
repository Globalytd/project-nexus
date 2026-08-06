package org.globalytd.projectnexus.feature.authentication.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.globalytd.projectnexus.core.navigation.NexusDestinations
import org.globalytd.projectnexus.feature.authentication.presentation.login.LoginRoute
import org.globalytd.projectnexus.feature.authentication.presentation.passkey.PasskeySetupRoute
import org.globalytd.projectnexus.feature.authentication.presentation.recovery.ForgotPasswordRoute
import org.globalytd.projectnexus.feature.authentication.presentation.registration.EmailRegistrationRoute
import org.globalytd.projectnexus.feature.authentication.presentation.registration.PhoneRegistrationRoute
import org.globalytd.projectnexus.feature.authentication.presentation.registration.RegistrationOptionsRoute
import org.globalytd.projectnexus.feature.authentication.presentation.twofactor.TwoFactorAuthRoute

fun NavGraphBuilder.authenticationGraph(navController: NavHostController) {
    composable(NexusDestinations.LOGIN) {
        LoginRoute(
            onLoginSuccess = { navController.navigate(NexusDestinations.VERIFICATION_INTRO) },
            onRegisterClick = { navController.navigate(NexusDestinations.REGISTRATION_OPTIONS) },
            onForgotPasswordClick = { navController.navigate(NexusDestinations.FORGOT_PASSWORD) },
            // TODO: When passkey authentication is implemented, navigate to a PASSKEY_SIGN_IN
            // destination instead of PASSKEY_SETUP. PASSKEY_SETUP is for new passkey registration only.
            onPasskeyClick = { navController.navigate(NexusDestinations.PASSKEY_SETUP) }
        )
    }
    composable(NexusDestinations.REGISTRATION_OPTIONS) {
        RegistrationOptionsRoute(
            onEmailRegister = { navController.navigate(NexusDestinations.EMAIL_REGISTRATION) },
            onPhoneRegister = { navController.navigate(NexusDestinations.PHONE_REGISTRATION) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.EMAIL_REGISTRATION) {
        EmailRegistrationRoute(
            onRegistrationSuccess = { navController.navigate(NexusDestinations.VERIFICATION_INTRO) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.PHONE_REGISTRATION) {
        PhoneRegistrationRoute(
            onContinue = { navController.navigate(NexusDestinations.TWO_FACTOR_AUTH) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.TWO_FACTOR_AUTH) {
        TwoFactorAuthRoute(
            onVerified = { navController.navigate(NexusDestinations.VERIFICATION_INTRO) },
            onBackClick = { navController.popBackStack() }
        )
    }
    composable(NexusDestinations.FORGOT_PASSWORD) {
        ForgotPasswordRoute(onBackClick = { navController.popBackStack() })
    }
    composable(NexusDestinations.PASSKEY_SETUP) {
        PasskeySetupRoute(
            onSetupComplete = { navController.navigate(NexusDestinations.VERIFICATION_INTRO) },
            onSkip = { navController.navigate(NexusDestinations.VERIFICATION_INTRO) },
            onBackClick = { navController.popBackStack() }
        )
    }
}
