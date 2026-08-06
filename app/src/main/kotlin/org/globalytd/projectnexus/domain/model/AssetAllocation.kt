package org.globalytd.projectnexus.domain.model

/** Represents a target allocation slice. Percentages must sum to 100. */
data class AssetAllocation(
    val etfPercent: Int,
    val stockPercent: Int,
    val cryptoPercent: Int,
    val bondPercent: Int,
    val cashPercent: Int
) {
    val total: Int get() = etfPercent + stockPercent + cryptoPercent + bondPercent + cashPercent
    val isValid: Boolean get() = total == 100
}
