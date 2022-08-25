package org.kredent.core.utils

import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import org.kredent.core.navigation.Back
import org.kredent.core.navigation.Navigate
import org.kredent.core.navigation.NavigationAction
import org.kredent.core.navigation.NavigationObserver
import org.kredent.core.navigation.Pop

val Fragment.parentNavigationObserver: NavigationObserver?
    get() {
        var parent = parentFragment
        while (parent != null) {
            if (parent is NavigationObserver) {
                return parent
            }
            parent = parent.parentFragment
        }
        return requireActivity() as? NavigationObserver
    }

inline fun Fragment.interceptBackPressed(crossinline block: () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(
        viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                block()
            }
        })
}

fun NavController.handle(action: NavigationAction) {
    when (action) {
        is Navigate -> navigate(action.directions)
        is Pop -> popBackStack(action.destinationId, action.inclusive)
        is Back -> popBackStack()
    }
}

@get:IdRes
val NavDestination.graphId: Int?
    get() = parent?.id

@get:IdRes
val NavController.graphId: Int?
    get() = currentDestination?.graphId
