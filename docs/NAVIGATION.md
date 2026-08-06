# Navigation

Project Nexus uses Jetpack Compose Navigation with a single-activity architecture.

## Route Constants

All route strings are defined in `core/navigation/NexusNavDestinations.kt` as constants in the `NexusDestinations` object.

## Navigation Graphs

| File | Scope |
|---|---|
| `AppNavigation.kt` | Root NavHost |
| `onboarding/navigation/OnboardingNavigation.kt` | Splash, Welcome, Onboarding |
| `authentication/navigation/AuthNavigation.kt` | Login, Registration, 2FA, etc. |
| `verification/navigation/VerificationNavigation.kt` | KYC flow |
| `home/navigation/MainNavigation.kt` | Authenticated main app with bottom nav |

## Demo Flow

```
Welcome → Login → Verification Introduction → Home
```

Additional links from Login:
- Email Registration
- Phone Registration
- Forgot Password
- Passkey Setup

## Rules

- Never pass `NavController` directly into a screen composable.
- Screens receive `onXxxClick: () -> Unit` callbacks only.
- Navigation logic stays in navigation files.
