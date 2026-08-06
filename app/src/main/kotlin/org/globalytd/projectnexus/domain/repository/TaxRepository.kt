package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.TaxSummary

interface TaxRepository {
    suspend fun getTaxSummary(userId: String, year: Int): Result<TaxSummary>
}
