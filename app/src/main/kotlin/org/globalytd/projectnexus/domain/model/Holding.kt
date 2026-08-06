package org.globalytd.projectnexus.domain.model

enum class AssetClass { STOCK, CRYPTO, ETF, BOND, CASH }

data class Holding(
    val id: String,
    val symbol: String,
    val name: String,
    val assetClass: AssetClass,
    val quantity: Double,
    val currentPrice: Double,
    val totalValue: Double,
    val gainLoss: Double,
    val gainLossPercent: Double
)
