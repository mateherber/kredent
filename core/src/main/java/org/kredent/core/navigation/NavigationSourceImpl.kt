package org.kredent.core.navigation

import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

class NavigationSourceImpl @Inject constructor() : NavigationSource {
    private val _navigationRequests = MutableStateFlow<NavigationRequest?>(null)
    override fun navigate(request: NavigationRequest) {
        _navigationRequests.value = request
    }

    override suspend fun observe(block: (NavigationRequest) -> Unit) {
        _navigationRequests.filterNotNull().collect {
            _navigationRequests.value = null
            block(it)
        }
    }
}
