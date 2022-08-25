package org.kredent.contact.ui

import androidx.fragment.app.viewModels
import org.kredent.core.ui.NavigationObserverFragment
import org.kredent.core.utils.interceptBackPressed
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : NavigationObserverFragment<ContactViewModel>() {
    override val viewModel: ContactViewModel by viewModels()
    override fun onCreateView() = kredentView {
        ContactScreen(viewModel)
    }

    /*
     * A hack needed because of current behavior in Bottom Navigation
     * https://gist.github.com/hoc081098/78092f44c3063fe78b34e4cdd3e7e7ad
     */
    override fun configure() = interceptBackPressed {
        viewModel.goBack()
    }
}
