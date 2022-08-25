package org.kredent.transactions.domain

import org.kredent.common.navigation.StartSecondLevelAuthentication
import org.kredent.core.di.GLOBAL_NAVIGATOR
import org.kredent.core.navigation.Navigator
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import kotlinx.coroutines.delay

@Singleton
class UpdateTransactionsAction @Inject constructor(
    @Named(GLOBAL_NAVIGATOR) private val navigator: Navigator
) {
    suspend fun update() {
        delay(3000)
        navigator.navigate(StartSecondLevelAuthentication)
    }
}
