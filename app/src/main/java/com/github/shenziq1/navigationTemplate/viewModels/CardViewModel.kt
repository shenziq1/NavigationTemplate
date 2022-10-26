package com.github.shenziq1.navigationTemplate.viewModels

import androidx.lifecycle.ViewModel
import com.github.shenziq1.navigationTemplate.uiStates.CardUiState
import com.github.shenziq1.navigationTemplate.uiStates.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CardViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CardUiState())
    val uiState: StateFlow<CardUiState> = _uiState.asStateFlow()

    fun updateCounter() {
        _uiState.update { it.copy(counter = it.counter + 1) }
    }

    init {
        reset()
    }

    private fun reset() {
        _uiState.update { it.copy() }
    }
}