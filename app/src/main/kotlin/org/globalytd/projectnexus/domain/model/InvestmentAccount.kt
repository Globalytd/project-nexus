package org.globalytd.projectnexus.domain.model

enum class AccountType { BROKERAGE, CRYPTO, RETIREMENT }

data class InvestmentAccount(
    val id: String,
    val name: String,
    val type: AccountType,
    val balance: Double
)
