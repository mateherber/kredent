package org.kredent.app.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.common.domain.AuthKeyRepository
import org.kredent.common.domain.TokenRepository
import org.kredent.core.di.GLOBAL_NAVIGATION_SOURCE
import org.kredent.core.navigation.NavigationSource
import org.kredent.app.R
import org.kredent.app.navigation.ToLogin
import org.kredent.app.navigation.ToTab
import org.kredent.app.navigation.ToToken
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    tokenRepository: TokenRepository,
    authKeyRepository: AuthKeyRepository,
    @Named(GLOBAL_NAVIGATION_SOURCE) navigationSource: NavigationSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(), NavigationSource by navigationSource {
    private val _initGraph = MutableStateFlow<Int?>(null)
    val initGraph = _initGraph.filterNotNull()

    init {
        viewModelScope.launch {
            combine(
                tokenRepository.token,
                authKeyRepository.authKey,
            ) { token, authKey ->
                val destination = when {
                    authKey == null -> org.kredent.login.R.id.loginGraph
                    token == null -> R.id.tokenFragment
                    else -> R.id.tabFragment
                }
                destination
            }
                .debounce(100) // TODO This is a hack to avoid multiple navigation when clearing both token and auth key after logout
                .collect {
                    if (savedStateHandle.get<Boolean>(GRAPH_SET_KEY) == true) {
                        val request = when (it) {
                            org.kredent.login.R.id.loginGraph -> ToLogin
                            R.id.tokenFragment -> ToToken
                            R.id.tabFragment -> ToTab
                            else -> null
                        } ?: throw IllegalStateException("Unknown graphId: $it")
                        navigate(request)
                    } else {
                        _initGraph.value = it
                    }
                }
        }
    }

    fun graphSetupFinished() {
        savedStateHandle[GRAPH_SET_KEY] = true
        _initGraph.value = null
    }

    companion object {
        const val GRAPH_SET_KEY = "GRAPH_SET_KEY"
    }
}
