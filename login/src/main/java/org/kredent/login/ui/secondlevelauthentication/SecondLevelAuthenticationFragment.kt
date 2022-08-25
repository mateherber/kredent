package org.kredent.login.ui.secondlevelauthentication

import androidx.fragment.app.viewModels
import org.kredent.core.ui.CoordinatedFragment
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondLevelAuthenticationFragment :
    CoordinatedFragment<SecondLevelAuthenticationCoordinator, SecondLevelAuthenticationViewModel>() {
    override val viewModel by viewModels<SecondLevelAuthenticationViewModel>()

    override fun onCreateView() = kredentView {
        SecondLevelAuthenticationScreen(viewModel)
    }
}
