package org.globalytd.projectnexus.data.repository

import org.globalytd.projectnexus.domain.model.AssetAllocation
import org.globalytd.projectnexus.domain.model.AssetClass
import org.globalytd.projectnexus.domain.model.Holding
import org.globalytd.projectnexus.domain.model.PortfolioSummary
import org.globalytd.projectnexus.domain.repository.PortfolioRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * FAKE IMPLEMENTATION – demonstration data only.
 * All values are fictional and do not represent real investments.
 */
@Singleton
class FakePortfolioRepository @Inject constructor() : PortfolioRepository {

    override suspend fun getPortfolioSummary(userId: String): Result<PortfolioSummary> =
        Result.success(
            PortfolioSummary(
                totalValue = 12_345.67,
                dailyChange = 234.50,
                dailyChangePercent = 1.94,
                cashAvailable = 1_500.00
            )
        )

    override suspend fun getHoldings(userId: String): Result<List<Holding>> =
        Result.success(
            listOf(
                Holding("h1", "AAPL", "Apple Inc.", AssetClass.STOCK, 10.0, 178.50, 1785.0, 145.0, 8.84),
                Holding("h2", "VTI", "Vanguard Total Market ETF", AssetClass.ETF, 20.0, 225.30, 4506.0, 400.0, 9.74),
                Holding("h3", "BTC", "Bitcoin", AssetClass.CRYPTO, 0.05, 42000.0, 2100.0, -50.0, -2.33),
                Holding("h4", "MSFT", "Microsoft Corp.", AssetClass.STOCK, 5.0, 375.0, 1875.0, 175.0, 10.29)
            )
        )

    override suspend fun getAllocation(userId: String): Result<AssetAllocation> =
        Result.success(AssetAllocation(etfPercent = 40, stockPercent = 30, cryptoPercent = 15, bondPercent = 10, cashPercent = 5))

    override suspend fun saveAllocation(userId: String, allocation: AssetAllocation): Result<Unit> =
        Result.success(Unit)
}
