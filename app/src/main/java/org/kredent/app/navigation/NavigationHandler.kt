package org.kredent.app.navigation

import androidx.navigation.NavController
import org.kredent.core.navigation.GoBack
import org.kredent.core.navigation.GoUp
import org.kredent.core.navigation.NavigationAction
import org.kredent.core.navigation.NavigationObserver
import org.kredent.core.navigation.NavigationRequest
import org.kredent.core.navigation.action
import org.kredent.core.utils.graphId
import org.kredent.core.utils.handle

interface NavigationHandler : NavigationObserver {
    val navController: NavController
    fun getAction(request: NavigationRequest): NavigationAction?

    override fun onNavigation(request: NavigationRequest): Boolean {
        val action = when (request) {
            is GoBack -> request.action
            is GoUp -> navController.graphId?.let { request.action(it) }
            else -> getAction(request)
        }
        if (action != null) {
            navController.handle(action)
            return true
        }
        return false
    }
}

