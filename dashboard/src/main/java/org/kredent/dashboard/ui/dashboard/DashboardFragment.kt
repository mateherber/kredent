package org.kredent.dashboard.ui.dashboard

import androidx.fragment.app.viewModels
import org.kredent.core.ui.NavigationObserverFragment
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : NavigationObserverFragment<DashboardViewModel>() {
    override val viewModel by viewModels<DashboardViewModel>()

    override fun onCreateView() = kredentView {
        DashboardScreen(viewModel)
    }
}
