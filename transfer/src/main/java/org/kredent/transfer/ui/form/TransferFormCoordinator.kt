package org.kredent.transfer.ui.form

interface TransferFormCoordinator {
    fun finishTransferForm(name: String, account: String, message: String)
    fun goBack()
}
