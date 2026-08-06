# Project Nexus

> **Status: Skeleton – all data is fake and placeholder**

Project Nexus is a mobile investment education and portfolio-management platform built with modern Android technologies.

## Technology Stack

| Technology | Version |
|---|---|
| Kotlin | 2.0.21 |
| Jetpack Compose | BOM 2024.09.03 |
| Material Design 3 | via Compose BOM |
| Navigation Compose | 2.8.2 |
| Hilt (Dependency Injection) | 2.51.1 |
| Kotlin Coroutines | 1.9.0 |
| Android Gradle Plugin | 8.5.2 |

## How to Open

1. Clone the repository
2. Open the project root in **Android Studio Hedgehog (2023.1.1)** or newer
3. Wait for Gradle sync to complete
4. Run on an emulator or device (API 26+)

## How to Run

```bash
./gradlew assembleDebug
./gradlew test
```

Or press the **Run** button in Android Studio.

## Package Overview

```
org.globalytd.projectnexus
├── core/designsystem   – NexusTheme, components, tokens
├── core/navigation     – Route constants, TopLevelDestination
├── data/repository     – Fake repository implementations
├── di                  – Hilt modules
├── domain/model        – Pure Kotlin domain models
├── domain/repository   – Repository interfaces
└── feature/*           – Feature screens and ViewModels
```

## ⚠️ All Current Data is Fake

Every portfolio value, user name, transaction, and learning record is hardcoded demonstration data. No real financial data is used.

## Current Limitations

- No backend or real authentication
- No camera access (liveness check and document upload are placeholders)
- No real database (Room not yet added)
- No networking (Retrofit not yet added)
- No real payment or brokerage integration

## Next Development Steps

1. **Naomi Ssenabulya** – Implement real authentication (Firebase Auth or custom backend)
2. **Joy Banadda** – Integrate a brokerage API for real portfolio data
3. **Khalan Nakibuka** – Replace chart placeholders with a real chart library
4. **Divine Kibazo** – Implement push notifications and security event logging
