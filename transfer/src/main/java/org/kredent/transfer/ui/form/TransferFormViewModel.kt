package org.kredent.transfer.ui.form

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.core.ui.CoordinatedViewModel
import org.kredent.core.ui.CoordinatorHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class TransferFormViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    holder: CoordinatorHolder<TransferFormCoordinator>
) : ViewModel(),
    CoordinatedViewModel<TransferFormCoordinator> by holder {
    private val nameFlow = savedStateHandle.getStateFlow(KEY_NAME, "")
    private val accountFlow = savedStateHandle.getStateFlow(KEY_ACCOUNT, "")
    private val messageFlow = savedStateHandle.getStateFlow(KEY_MESSAGE, "")

    val uiState = combine(nameFlow, accountFlow, messageFlow) { name, account, message ->
        UiState(name, account, message)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        UiState("", "", "")
    )

    fun changeName(name: String) {
        savedStateHandle[KEY_NAME] = name
    }

    fun changeAccount(account: String) {
        savedStateHandle[KEY_ACCOUNT] = account
    }

    fun changeMessage(message: String) {
        savedStateHandle[KEY_MESSAGE] = message
    }

    fun finishTransferForm() {
        coordinator.finishTransferForm(
            nameFlow.value,
            accountFlow.value,
            messageFlow.value
        )
    }

    fun goBack() {
        coordinator.goBack()
    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_ACCOUNT = "key_account"
        const val KEY_MESSAGE = "key_message"
    }
}

data class UiState(
    val name: String,
    val account: String,
    val message: String
)
