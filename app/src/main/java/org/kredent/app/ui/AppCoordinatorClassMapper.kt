package org.kredent.app.ui

import androidx.lifecycle.ViewModel
import org.kredent.core.ui.CoordinatorClassMapper
import org.kredent.login.ui.LoginCoordinator
import org.kredent.transfer.ui.TransferCoordinator
import javax.inject.Inject

class AppCoordinatorClassMapper @Inject constructor() : CoordinatorClassMapper {
    override fun getCoordinatorClass(graphId: Int): Class<out ViewModel>? = when (graphId) {
        org.kredent.login.R.id.loginGraph -> LoginCoordinator::class.java
        org.kredent.app.R.id.mainGraph -> MainCoordinator::class.java
        org.kredent.transfer.R.id.transferGraph -> TransferCoordinator::class.java
        else -> null
    }
}
