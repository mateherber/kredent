package org.kredent.common.di

import org.kredent.common.data.AuthKeyRepositoryImpl
import org.kredent.common.data.TokenRepositoryImpl
import org.kredent.common.domain.AuthKeyRepository
import org.kredent.common.domain.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Singleton
    @Binds
    fun bindAuthKeyRepository(authKeyRepositoryImpl: AuthKeyRepositoryImpl): AuthKeyRepository

    @Singleton
    @Binds
    fun bindTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository
}
