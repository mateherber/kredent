package org.kredent.contact.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.common.domain.AuthKeyRepository
import org.kredent.common.domain.TokenRepository
import org.kredent.core.navigation.GoBack
import org.kredent.core.navigation.NavigationSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ContactViewModel @Inject constructor(
    navigationSource: NavigationSource,
    private val tokenRepository: TokenRepository,
    private val authKeyRepository: AuthKeyRepository
) : ViewModel(), NavigationSource by navigationSource {
    fun logout() {
        viewModelScope.launch {
            tokenRepository.setToken(null)
            authKeyRepository.setAuthKey(null)
        }
    }

    fun goBack() {
        navigate(GoBack)
    }
}
