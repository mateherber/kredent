package org.kredent.transactions.ui

import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import org.kredent.core.ui.NavigationObserverFragment
import org.kredent.core.utils.interceptBackPressed
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalLifecycleComposeApi
class TransactionsFragment : NavigationObserverFragment<TransactionsViewModel>() {
    override val viewModel by viewModels<TransactionsViewModel>()

    override fun onCreateView() = kredentView {
        TransactionsScreen(viewModel)
    }

    /*
     * A hack needed because of current behavior in Bottom Navigation
     * https://gist.github.com/hoc081098/78092f44c3063fe78b34e4cdd3e7e7ad
     */
    override fun configure() = interceptBackPressed {
        viewModel.goBack()
    }
}


