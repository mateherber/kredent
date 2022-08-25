package org.kredent.transfer.ui

import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import org.kredent.core.navigation.GoBack
import org.kredent.core.navigation.GoUp
import org.kredent.core.navigation.NavigationSource
import org.kredent.transfer.navigation.OpenTransferAmount
import org.kredent.transfer.navigation.OpenTransferSummary
import org.kredent.transfer.ui.amount.TransferAmountCoordinator
import org.kredent.transfer.ui.form.TransferFormCoordinator
import org.kredent.transfer.ui.summary.TransferSummaryCoordinator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.parcelize.Parcelize

@HiltViewModel
class TransferCoordinator @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    navigationSource: NavigationSource,
) : ViewModel(),
    TransferFormCoordinator,
    TransferAmountCoordinator,
    TransferSummaryCoordinator,
    NavigationSource by navigationSource {
    private val draftFlow = savedStateHandle.getStateFlow(
        KEY_DRAFT,
        TransferDraft(null, null, null, null)
    )

    override fun finishTransferForm(name: String, account: String, message: String) {
        savedStateHandle[KEY_DRAFT] = draftFlow.value.copy(
            name = name,
            account = account,
            message = message
        )
        navigate(OpenTransferAmount(name, account))
    }

    override fun goBack() {
        navigate(GoBack)
    }

    override fun goUp() {
        navigate(GoUp)
    }

    override fun finishTransferAmount(amount: String) {
        val draft = draftFlow.value.copy(amount = amount)
        savedStateHandle[KEY_DRAFT] = draft
        navigate(
            OpenTransferSummary(
                draft.name!!,
                draft.account!!,
                draft.message!!,
                amount
            )
        )
    }

    companion object {
        const val KEY_DRAFT = "key_draft"
    }

    override fun finishTransfer() {
        navigate(GoUp)
    }
}

@Parcelize
data class TransferDraft(
    val name: String?,
    val account: String?,
    val message: String?,
    val amount: String?
) : Parcelable
