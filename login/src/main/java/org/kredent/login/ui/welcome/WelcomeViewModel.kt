package org.kredent.login.ui.welcome

import androidx.lifecycle.ViewModel
import org.kredent.core.ui.CoordinatedViewModel
import org.kredent.core.ui.CoordinatorHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    holder: CoordinatorHolder<WelcomeCoordinator>
) : ViewModel(),
    CoordinatedViewModel<WelcomeCoordinator> by holder {
    fun login() {
        coordinator.login()
    }
}
