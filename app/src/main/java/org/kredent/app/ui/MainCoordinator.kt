package org.kredent.app.ui

import androidx.lifecycle.ViewModel
import org.kredent.core.navigation.GoBack
import org.kredent.core.navigation.NavigationSource
import org.kredent.app.di.MAIN_CONTENT_REPOSITORY
import org.kredent.login.domain.ContentRepository
import org.kredent.login.ui.secondlevelauthentication.SecondLevelAuthenticationCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainCoordinator @Inject constructor(
    navigationSource: NavigationSource,
    @Named(MAIN_CONTENT_REPOSITORY) val contentRepository: ContentRepository
) : ViewModel(), NavigationSource by navigationSource, SecondLevelAuthenticationCoordinator {

    override suspend fun authenticate() {
        navigate(GoBack)
    }

    override suspend fun fetchContent() = contentRepository.fetchContent()
}
