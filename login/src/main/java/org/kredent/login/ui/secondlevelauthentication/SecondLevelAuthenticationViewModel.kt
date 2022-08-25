package org.kredent.login.ui.secondlevelauthentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.core.ui.CoordinatedViewModel
import org.kredent.core.ui.CoordinatorHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SecondLevelAuthenticationViewModel @Inject constructor(
    holder: CoordinatorHolder<SecondLevelAuthenticationCoordinator>
) : ViewModel(),
    CoordinatedViewModel<SecondLevelAuthenticationCoordinator> by holder {

    private val _uiState = MutableStateFlow<SecondLevelAuthenticationViewState>(Loading)
    val uiState = _uiState.asStateFlow()

    override fun onStart() {
        viewModelScope.launch {
            _uiState.value =
                Content(coordinator.fetchContent())
        }
    }

    fun authenticate() {
        viewModelScope.launch {
            coordinator.authenticate()
        }
    }
}
