package org.kredent.core.navigation

import androidx.annotation.IdRes
import androidx.navigation.NavDirections

sealed interface NavigationAction
data class Navigate(val directions: NavDirections) : NavigationAction
data class Pop(@IdRes val destinationId: Int, val inclusive: Boolean) : NavigationAction
object Back : NavigationAction
