package org.globalytd.projectnexus.domain.model

enum class RiskLevel { CONSERVATIVE, MODERATE, AGGRESSIVE }

data class Blueprint(
    val id: String,
    val title: String,
    val creator: String,
    val riskLevel: RiskLevel,
    val allocation: AssetAllocation,
    val description: String
)
