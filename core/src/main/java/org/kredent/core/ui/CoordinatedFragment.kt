package org.kredent.core.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import org.kredent.core.navigation.NavigationObserver
import org.kredent.core.navigation.NavigationSource
import org.kredent.core.utils.parentNavigationObserver
import javax.inject.Inject

abstract class CoordinatedFragment<C : Any, VM : CoordinatedViewModel<C>> : Fragment(),
    CoordinatedScreen<C, VM>,
    NavigationObserver {
    final override val coordinator by coordinator<C>()

    @Inject
    final override lateinit var coordinatorClassMapper: CoordinatorClassMapper

    final override val activity: Activity
        get() = requireActivity()

    final override val parent: NavigationObserver?
        get() = parentNavigationObserver

    final override val navController: NavController
        get() = findNavController()

    abstract fun onCreateView(): View

    open fun configure() {}

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        attachCoordinator()
        observeNavigation(coordinator as NavigationSource)
        configure()
        return onCreateView()
    }
}
