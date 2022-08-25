package org.kredent.dashboard.navigation

import org.kredent.core.navigation.NavigationRequest

data class OpenDetails(
    val name: String,
    val color: ULong,
    val onColor: ULong
) : NavigationRequest
