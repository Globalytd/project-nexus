package org.globalytd.projectnexus

import kotlinx.coroutines.test.runTest
import org.globalytd.projectnexus.data.repository.FakePortfolioRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FakePortfolioRepositoryTest {

    private val repository = FakePortfolioRepository()

    @Test
    fun `getPortfolioSummary returns success with positive total value`() = runTest {
        val result = repository.getPortfolioSummary("test-user")
        assertTrue(result.isSuccess)
        assertTrue(result.getOrThrow().totalValue > 0)
    }

    @Test
    fun `getHoldings returns non-empty list`() = runTest {
        val result = repository.getHoldings("test-user")
        assertTrue(result.isSuccess)
        assertTrue(result.getOrThrow().isNotEmpty())
    }

    @Test
    fun `getAllocation total equals 100`() = runTest {
        val result = repository.getAllocation("test-user")
        assertTrue(result.isSuccess)
        assertEquals(100, result.getOrThrow().total)
    }
}
