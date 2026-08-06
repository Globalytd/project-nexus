package org.globalytd.projectnexus.core.navigation

/**
 * Centralised route constants for the entire application.
 * Feature navigation graphs reference these objects so route names
 * stay consistent and refactoring is easy.
 */
object NexusDestinations {
    // Onboarding
    const val SPLASH = "splash"
    const val WELCOME = "welcome"
    const val ONBOARDING = "onboarding"

    // Authentication
    const val LOGIN = "login"
    const val REGISTRATION_OPTIONS = "registration_options"
    const val EMAIL_REGISTRATION = "email_registration"
    const val PHONE_REGISTRATION = "phone_registration"
    const val TWO_FACTOR_AUTH = "two_factor_auth"
    const val FORGOT_PASSWORD = "forgot_password"
    const val PASSKEY_SETUP = "passkey_setup"

    // Identity verification
    const val VERIFICATION_INTRO = "verification_intro"
    const val PERSONAL_INFORMATION = "personal_information"
    const val DOCUMENT_VERIFICATION = "document_verification"
    const val LIVENESS_CHECK = "liveness_check"
    const val VERIFICATION_STATUS = "verification_status"

    // Main
    const val MAIN = "main"

    // Home
    const val HOME = "home"

    // Portfolio
    const val PORTFOLIO = "portfolio"
    const val ALLOCATION = "allocation"
    const val REBALANCING = "rebalancing"

    // Invest
    const val INVEST = "invest"

    // Blueprints
    const val BLUEPRINT_LIST = "blueprint_list"
    const val BLUEPRINT_DETAILS = "blueprint_details/{blueprintId}"
    fun blueprintDetails(id: String) = "blueprint_details/$id"

    // Community
    const val COMMUNITY = "community"
    const val LEADERBOARD = "leaderboard"
    const val ACHIEVEMENTS = "achievements"

    // Learning
    const val LEARNING_HOME = "learning_home"
    const val LESSON_DETAILS = "lesson_details/{lessonId}"
    fun lessonDetails(id: String) = "lesson_details/$id"

    // Tax
    const val TAX_CENTER = "tax_center"

    // Profile, Security, Settings, Notifications
    const val PROFILE = "profile"
    const val SECURITY = "security_settings"
    const val GUARDIAN_RECOVERY = "guardian_recovery"
    const val NOTIFICATIONS = "notifications"
    const val SETTINGS = "settings"
}
