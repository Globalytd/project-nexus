package org.globalytd.projectnexus.domain.repository

import org.globalytd.projectnexus.domain.model.InvestmentAccount
import org.globalytd.projectnexus.domain.model.Transaction

interface InvestmentRepository {
    suspend fun getAccounts(userId: String): Result<List<InvestmentAccount>>
    suspend fun getTransactions(userId: String): Result<List<Transaction>>
}
