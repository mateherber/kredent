package org.kredent.login.di

import org.kredent.login.data.LoginContentRepository
import org.kredent.login.domain.ContentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

const val LOGIN_CONTENT_REPOSITORY = "LoginContentRepository"

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    @ViewModelScoped
    @Named(LOGIN_CONTENT_REPOSITORY)
    fun bindContentRepository(loginContentRepository: LoginContentRepository): ContentRepository
}
