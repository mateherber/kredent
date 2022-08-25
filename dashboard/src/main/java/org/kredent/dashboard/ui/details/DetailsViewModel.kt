package org.kredent.dashboard.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow<String?>(null)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _state.value =
                "Args read from viewModel: ${
                    DetailsFragmentArgs.fromSavedStateHandle(
                        savedStateHandle
                    ).detailsArgs.name
                }"
        }
    }

    fun consumeMessage() {
        _state.value = null
    }
}
