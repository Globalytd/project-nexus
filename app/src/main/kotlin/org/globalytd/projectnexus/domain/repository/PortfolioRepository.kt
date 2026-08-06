package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.AssetAllocation
import org.globalytd.projectnexus.domain.model.Holding
import org.globalytd.projectnexus.domain.model.PortfolioSummary

interface PortfolioRepository {
    suspend fun getPortfolioSummary(userId: String): Result<PortfolioSummary>
    suspend fun getHoldings(userId: String): Result<List<Holding>>
    suspend fun getAllocation(userId: String): Result<AssetAllocation>
    suspend fun saveAllocation(userId: String, allocation: AssetAllocation): Result<Unit>
}
