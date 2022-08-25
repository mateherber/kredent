package org.kredent.login.ui

import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import org.kredent.common.domain.AuthKeyRepository
import org.kredent.common.navigation.StartSecondLevelAuthentication
import org.kredent.core.navigation.NavigationSource
import org.kredent.login.di.LOGIN_CONTENT_REPOSITORY
import org.kredent.login.domain.ContentRepository
import org.kredent.login.ui.secondlevelauthentication.SecondLevelAuthenticationCoordinator
import org.kredent.login.ui.welcome.WelcomeCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import kotlinx.parcelize.Parcelize

@HiltViewModel
class LoginCoordinator @Inject constructor(
    savedStateHandle: SavedStateHandle,
    navigationSource: NavigationSource,
    private val authKeyRepository: AuthKeyRepository,
    @Named(LOGIN_CONTENT_REPOSITORY) val contentRepository: ContentRepository
) : ViewModel(),
    NavigationSource by navigationSource,
    WelcomeCoordinator,
    SecondLevelAuthenticationCoordinator {

    private val draftFlow = savedStateHandle.getStateFlow(
        KEY_DRAFT,
        LoginDraft((UUID.randomUUID().toString()))
    )

    companion object {
        const val KEY_DRAFT = "KEY_DRAFT"
    }

    override suspend fun authenticate() {
        authKeyRepository.setAuthKey(draftFlow.value.id)
    }

    override suspend fun fetchContent() = contentRepository.fetchContent()

    override fun login() {
        navigate(StartSecondLevelAuthentication)
    }
}

@Parcelize
data class LoginDraft(val id: String) : Parcelable
