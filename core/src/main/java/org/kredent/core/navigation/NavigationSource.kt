package org.kredent.core.navigation

interface NavigationSource : Navigator {
    suspend fun observe(block: (NavigationRequest) -> Unit)
}
