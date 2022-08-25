package org.kredent.transfer.ui.amount

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.core.ui.CoordinatedViewModel
import org.kredent.core.ui.CoordinatorHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class TransferAmountViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    holder: CoordinatorHolder<TransferAmountCoordinator>
) : ViewModel(),
    CoordinatedViewModel<TransferAmountCoordinator> by holder {
    private val args =
        TransferAmountFragmentArgs.fromSavedStateHandle(savedStateHandle).transferAmountArgs
    private val name = args.name
    private val account = args.account
    private val amountFlow = savedStateHandle.getStateFlow(KEY_AMOUNT, "")

    val uiState = amountFlow.map { createUiState(it) }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        createUiState("")
    )

    fun changeAmount(message: String) {
        savedStateHandle[KEY_AMOUNT] = message
    }

    fun finishTransferAmount() {
        coordinator.finishTransferAmount(amountFlow.value)
    }

    fun goBack() {
        coordinator.goBack()
    }

    private fun createUiState(amount: String) = UiState(name, account, amount)

    companion object {
        const val KEY_AMOUNT = "key_amount"
    }
}

data class UiState(
    val name: String,
    val account: String,
    val amount: String
)
