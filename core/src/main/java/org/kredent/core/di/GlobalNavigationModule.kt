package org.kredent.core.di

import org.kredent.core.navigation.NavigationSource
import org.kredent.core.navigation.NavigationSourceImpl
import org.kredent.core.navigation.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

const val GLOBAL_NAVIGATOR = "global_navigator"
const val GLOBAL_NAVIGATION_SOURCE = "global_navigation_source"

@Module
@InstallIn(SingletonComponent::class)
interface GlobalNavigationModule {
    @Binds
    @Singleton
    @Named(GLOBAL_NAVIGATOR)
    fun bindNavigator(@Named(GLOBAL_NAVIGATION_SOURCE) navigationSource: NavigationSource): Navigator

    @Binds
    @Singleton
    @Named(GLOBAL_NAVIGATION_SOURCE)
    fun bindNavigationSource(navigationSourceImpl: NavigationSourceImpl): NavigationSource
}
