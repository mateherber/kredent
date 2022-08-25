package org.kredent.core.navigation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

interface NavigationObserver {
    val parent: NavigationObserver?
    fun onNavigation(request: NavigationRequest): Boolean = false

    // TODO context receivers
    fun Fragment.observeNavigation(source: NavigationSource) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                observe(source)
            }
        }
    }
}

fun NavigationObserver.navigate(request: NavigationRequest) {
    if (onNavigation(request)) {
        return
    }
    parent?.navigate(request)
}

suspend fun NavigationObserver.observe(source: NavigationSource) {
    source.observe { navigate(it) }
}
