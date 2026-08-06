package org.globalytd.projectnexus.domain.model

enum class TransactionType { BUY, SELL, DIVIDEND, DEPOSIT, WITHDRAWAL }

data class Transaction(
    val id: String,
    val type: TransactionType,
    val symbol: String?,
    val amount: Double,
    val date: String // ISO-8601 date string; use LocalDate when a date library is added
)
