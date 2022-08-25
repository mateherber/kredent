package org.kredent.app.navigation

import org.kredent.common.navigation.StartNewTransfer
import org.kredent.common.navigation.StartSecondLevelAuthentication
import org.kredent.core.navigation.Navigate
import org.kredent.dashboard.navigation.OpenDetails
import org.kredent.dashboard.navigation.details.DetailsArgs
import org.kredent.dashboard.ui.dashboard.DashboardFragmentDirections
import org.kredent.app.MainGraphDirections
import org.kredent.login.navigation.LoginSuccessful
import org.kredent.transfer.navigation.OpenTransferAmount
import org.kredent.transfer.navigation.OpenTransferSummary
import org.kredent.transfer.navigation.amount.TransferAmountArgs
import org.kredent.transfer.navigation.summary.TransferSummaryArgs
import org.kredent.transfer.ui.amount.TransferAmountFragmentDirections
import org.kredent.transfer.ui.form.TransferFormFragmentDirections

val ToLogin.action
    get() = Navigate(MainGraphDirections.toLogin())

val ToToken.action
    get() = Navigate(MainGraphDirections.toToken())

val ToTab.action
    get() = Navigate(MainGraphDirections.toTab())

val LoginSuccessful.action
    get() = Navigate(MainGraphDirections.toTab())

val StartSecondLevelAuthentication.action
    get() = Navigate(MainGraphDirections.toSecondLevelAuthentication())

val OpenDetails.action
    get() = Navigate(DashboardFragmentDirections.toDetails(DetailsArgs(name, color, onColor)))

val StartNewTransfer.action
    get() = Navigate(MainGraphDirections.toTransfer())

val OpenTransferAmount.action
    get() = Navigate(
        TransferFormFragmentDirections.toTransferAmount(TransferAmountArgs(name, account))
    )

val OpenTransferSummary.action
    get() = Navigate(
        TransferAmountFragmentDirections.toTransferSummary(
            TransferSummaryArgs(
                name,
                account,
                message,
                amount
            )
        )
    )
