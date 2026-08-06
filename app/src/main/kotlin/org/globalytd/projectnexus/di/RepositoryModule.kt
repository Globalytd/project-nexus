package org.globalytd.projectnexus.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.globalytd.projectnexus.data.repository.FakeAuthRepository
import org.globalytd.projectnexus.data.repository.FakeCommunityRepository
import org.globalytd.projectnexus.data.repository.FakeLearningRepository
import org.globalytd.projectnexus.data.repository.FakePortfolioRepository
import org.globalytd.projectnexus.domain.repository.AuthRepository
import org.globalytd.projectnexus.domain.repository.CommunityRepository
import org.globalytd.projectnexus.domain.repository.LearningRepository
import org.globalytd.projectnexus.domain.repository.PortfolioRepository
import javax.inject.Singleton

/**
 * Hilt module that binds fake repository implementations during the skeleton phase.
 * Replace fake bindings with real implementations as each feature is built.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(fake: FakeAuthRepository): AuthRepository

    @Binds
    @Singleton
    abstract fun bindPortfolioRepository(fake: FakePortfolioRepository): PortfolioRepository

    @Binds
    @Singleton
    abstract fun bindLearningRepository(fake: FakeLearningRepository): LearningRepository

    @Binds
    @Singleton
    abstract fun bindCommunityRepository(fake: FakeCommunityRepository): CommunityRepository
}
