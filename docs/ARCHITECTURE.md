# Architecture

Project Nexus uses a layered architecture with unidirectional data flow.

## Layer Overview

```
Compose UI
    ↓ events (UiAction)
ViewModel + UiState (StateFlow)
    ↓ calls
Repository Interface
    ↓ implemented by
Fake Data Source (now) → Remote / Local Data Source (later)
```

## Packages

### core/
Shared code used by all features: design system, navigation helpers, common utilities.

### domain/
Pure Kotlin business models and repository interfaces. No Android framework imports.

### data/
Concrete repository implementations. Currently all fake (`Fake*Repository`).

### feature/
Each feature owns its own screens, ViewModels, and navigation graph.

### di/
Hilt modules that wire interfaces to implementations.

## Screen Architecture

Each meaningful screen has three layers:

1. **Route** – obtains `ViewModel` via `hiltViewModel()`, collects `StateFlow` state, passes events back up.
2. **Screen** – receives state and callbacks; no ViewModel reference.
3. **Content** – stateless UI building blocks used inside Screen and in Previews.

## State Management

- UI state is an immutable `data class`.
- User actions are a `sealed interface`.
- State is exposed via `StateFlow` from ViewModel.
- Compose collects state with `collectAsStateWithLifecycle()`.

## Use Cases

Add use cases only when business logic is reusable across multiple ViewModels or coordinates multiple repositories. Do not create a use case for a one-line repository call.

## Adding a Dependency

See `gradle/libs.versions.toml`. Add versions, libraries, and plugins there before referencing them in `build.gradle.kts`.
