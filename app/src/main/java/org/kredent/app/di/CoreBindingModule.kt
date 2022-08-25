package org.kredent.app.di

import org.kredent.core.ui.CoordinatorClassMapper
import org.kredent.app.ui.AppCoordinatorClassMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoreBindingModule {
    @Binds
    @Singleton
    fun bindCoordinatorClassMapper(appCoordinatorClassMapper: AppCoordinatorClassMapper): CoordinatorClassMapper
}
