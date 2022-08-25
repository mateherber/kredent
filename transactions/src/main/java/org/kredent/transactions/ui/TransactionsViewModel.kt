package org.kredent.transactions.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.kredent.common.navigation.StartNewTransfer
import org.kredent.core.navigation.GoBack
import org.kredent.core.navigation.NavigationSource
import org.kredent.transactions.domain.UpdateTransactionsAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    navigationSource: NavigationSource,
    private val updateTransactionsAction: UpdateTransactionsAction
) : ViewModel(), NavigationSource by navigationSource {
    private val _uiState = MutableStateFlow(TransactionsState.IDLE)
    val uiState = _uiState.asStateFlow()
    fun requestTransactions() {
        viewModelScope.launch {
            _uiState.value = TransactionsState.LOADING
            updateTransactionsAction.update()
            _uiState.value = TransactionsState.IDLE
        }
    }

    fun startTransfer() {
        navigate(StartNewTransfer)
    }

    fun goBack() {
        navigate(GoBack)
    }
}
