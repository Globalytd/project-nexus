# Design System

## NexusTheme

Wraps all screens. Provides Material 3 colour scheme, typography, shapes, and custom tokens via `CompositionLocalProvider`.

## Tokens

| Token | Class | Access |
|---|---|---|
| Colours | `NexusColors.kt` | `MaterialTheme.colorScheme` |
| Typography | `NexusTypography` | `MaterialTheme.typography` |
| Shapes | `NexusShapes` | `MaterialTheme.shapes` |
| Spacing | `NexusSpacing` | `LocalNexusSpacing.current` |
| Dimensions | `NexusDimensions` | `LocalNexusDimensions.current` |

## Components

| Component | Description |
|---|---|
| `NexusPrimaryButton` | Full-width primary action button |
| `NexusSecondaryButton` | Full-width outlined button |
| `NexusTextButton` | Text-only button |
| `NexusTextField` | Standard outlined text field |
| `NexusPasswordField` | Password field with visibility toggle |
| `NexusPhoneField` | Phone input with phone icon |
| `NexusPercentageField` | Numeric field with `%` suffix |
| `NexusTopAppBar` | Centred top bar with optional back arrow |
| `NexusBottomNavigationBar` | Material 3 bottom nav for 5 destinations |
| `NexusCard` | Rounded surface card |
| `NexusSummaryCard` | Card with title, value, subtitle |
| `NexusSectionHeader` | Row with title and optional action |
| `NexusListItem` | Row with leading, title, subtitle, trailing |
| `NexusLoadingIndicator` | Centred circular progress |
| `NexusEmptyState` | Empty icon + message |
| `NexusErrorState` | Error icon + message |
| `NexusStatusChip` | Coloured suggestion chip |
| `NexusChartPlaceholder` | Placeholder box for charts |
| `NexusAvatar` | Circular initials avatar |
| `NexusDivider` | Themed horizontal divider |
| `NexusScreenScaffold` | Full-screen surface wrapper |

## Colour Philosophy

- Calm neutral backgrounds
- Single primary accent (Nexus Blue `#2563EB`)
- Positive/negative financial colours used carefully
- Accessible contrast in both light and dark themes
