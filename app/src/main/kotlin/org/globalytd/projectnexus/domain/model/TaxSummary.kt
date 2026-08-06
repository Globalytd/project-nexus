package org.globalytd.projectnexus.domain.model

/**
 * Placeholder tax summary.
 * NOT tax advice. For demonstration only.
 */
data class TaxSummary(
    val taxYear: Int,
    val shortTermGains: Double,
    val longTermGains: Double,
    val totalIncome: Double,
    val totalTransactions: Int
)
