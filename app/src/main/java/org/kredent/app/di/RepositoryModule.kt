package org.kredent.app.di

import org.kredent.app.data.MainContentRepository
import org.kredent.login.domain.ContentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

const val MAIN_CONTENT_REPOSITORY = "MainContentRepository"

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    @ViewModelScoped
    @Named(MAIN_CONTENT_REPOSITORY)
    fun bindContentRepository(mainContentRepository: MainContentRepository): ContentRepository
}
