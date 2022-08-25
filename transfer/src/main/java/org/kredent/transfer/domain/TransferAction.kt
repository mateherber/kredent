package org.kredent.transfer.domain

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay

@Singleton
class TransferAction @Inject constructor() {
    @Suppress("UNUSED_PARAMETER")
    suspend fun sendTransfer(
        name: String,
        account: String,
        message: String,
        amount: String
    ) {
        delay(5000)
    }
}
