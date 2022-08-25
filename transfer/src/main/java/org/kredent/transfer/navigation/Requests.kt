package org.kredent.transfer.navigation

import org.kredent.core.navigation.NavigationRequest

data class OpenTransferAmount(val name: String, val account: String) : NavigationRequest
data class OpenTransferSummary(
    val name: String,
    val account: String,
    val message: String,
    val amount: String
) : NavigationRequest
