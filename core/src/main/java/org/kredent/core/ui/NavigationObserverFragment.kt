package org.kredent.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.kredent.core.navigation.NavigationObserver
import org.kredent.core.navigation.NavigationSource
import org.kredent.core.utils.parentNavigationObserver

abstract class NavigationObserverFragment<VM : NavigationSource> : Fragment(), NavigationObserver {
    abstract val viewModel: VM

    final override val parent: NavigationObserver?
        get() = parentNavigationObserver

    abstract fun onCreateView(): View
    open fun configure() {}
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        observeNavigation(viewModel)
        configure()
        return onCreateView()
    }
}
