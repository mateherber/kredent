package org.kredent.core.navigation

import androidx.annotation.IdRes

object GoBack : NavigationRequest
object GoUp : NavigationRequest

val GoBack.action
    get() = Back

fun GoUp.action(@IdRes graphId: Int) = Pop(graphId, true)
