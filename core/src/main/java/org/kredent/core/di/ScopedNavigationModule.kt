package org.kredent.core.di

import org.kredent.core.navigation.NavigationSource
import org.kredent.core.navigation.NavigationSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface ScopedNavigationModule {
    @Binds
    @ViewModelScoped
    fun bindNavigationSource(navigationSourceImpl: NavigationSourceImpl): NavigationSource
}



