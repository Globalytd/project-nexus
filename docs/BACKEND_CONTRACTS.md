# Backend Contracts

This document describes the interfaces that the backend must implement for each repository.

## AuthRepository

```
POST /auth/login        { email, password } → User
POST /auth/register     { email, password, displayName } → User
POST /auth/logout       {} → Unit
GET  /auth/me           → User?
POST /auth/reset        { email } → Unit
```

## PortfolioRepository

```
GET /portfolio/{userId}/summary   → PortfolioSummary
GET /portfolio/{userId}/holdings  → List<Holding>
GET /portfolio/{userId}/allocation → AssetAllocation
PUT /portfolio/{userId}/allocation { allocation } → Unit
```

All endpoints require a valid ****** in the `Authorization` header.

Data formats will be specified in the API documentation added when Retrofit is introduced.
