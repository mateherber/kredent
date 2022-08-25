package org.kredent.login.ui.welcome

import androidx.fragment.app.viewModels
import org.kredent.core.ui.CoordinatedFragment
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : CoordinatedFragment<WelcomeCoordinator, WelcomeViewModel>() {
    override val viewModel by viewModels<WelcomeViewModel>()

    override fun onCreateView() = kredentView {
        WelcomeScreen(viewModel)
    }
}
