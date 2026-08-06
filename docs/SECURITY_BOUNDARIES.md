# Security Boundaries

## What This Skeleton Does NOT Implement

The following functionality is intentionally absent from this skeleton and must never be added without a proper security review:

- Real authentication tokens or session management
- Password storage (even hashed)
- Personal data logging
- KYC / AML / liveness algorithms
- Encryption or key management
- Real brokerage or cryptocurrency transactions
- Payment processing
- Real API keys or secrets in source code
- Biometric authentication flows

## Fake Data Policy

All portfolio values, user information, and transaction records are hardcoded demonstration data clearly labelled as fake. They must never be presented to users as real financial information.

## When Adding Real Features

- Authentication: use a well-audited library (e.g., Firebase Auth, Auth0, passkey APIs)
- Storage: use Android Keystore for secrets; never store credentials in SharedPreferences
- Network: use HTTPS only; validate certificates
- Personal data: minimise collection; comply with GDPR and relevant local laws
- Biometric: use BiometricPrompt API; never build custom liveness detection

## Code Review Checklist

Before merging any security-sensitive code:
- [ ] No passwords or tokens in logs
- [ ] No secrets in source code
- [ ] No real financial calculations presented as advice
- [ ] GDPR implications considered
