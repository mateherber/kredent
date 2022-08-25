package org.kredent.transfer.ui.summary

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.core.ui.CoordinatedViewModel
import org.kredent.core.ui.CoordinatorHolder
import org.kredent.transfer.domain.TransferAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class TransferSummaryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val transferAction: TransferAction,
    holder: CoordinatorHolder<TransferSummaryCoordinator>,
) : ViewModel(),
    CoordinatedViewModel<TransferSummaryCoordinator> by holder {
    private val args =
        TransferSummaryFragmentArgs.fromSavedStateHandle(savedStateHandle).transferSummaryArgs
    private val _uiState =
        MutableStateFlow(UiState(args.name, args.account, args.message, args.amount, false))
    val uiState = _uiState.asStateFlow()

    fun finishTransferSummary() {
        _uiState.value = _uiState.value.copy(transferPending = true)
        viewModelScope.launch {
            transferAction.sendTransfer(args.account, args.amount, args.message, args.amount)
            _uiState.value = _uiState.value.copy(transferPending = false)
            coordinator.finishTransfer()
        }
    }

    fun goUp() {
        coordinator.goUp()
    }
}

data class UiState(
    val name: String,
    val account: String,
    val message: String,
    val amount: String,
    val transferPending: Boolean
)
