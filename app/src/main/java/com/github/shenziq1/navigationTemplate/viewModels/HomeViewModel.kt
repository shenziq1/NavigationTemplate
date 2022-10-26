package com.github.shenziq1.navigationTemplate.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.github.shenziq1.navigationTemplate.models.HomeGameTabData
import com.github.shenziq1.navigationTemplate.uiStates.CardUiState
import com.github.shenziq1.navigationTemplate.uiStates.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun initCardUiState(){
        _uiState.update { it.copy(gameCardUiStates = mutableStateListOf(CardViewModel()))}
    }

    fun updateHomeCount() {
        _uiState.update { it.copy(homeCounter = it.homeCounter + 1) }
    }

    fun updateOptionalCount() {
        _uiState.update { it.copy(optionalCounter = it.optionalCounter + 1) }
    }

    fun updateTabSelected(tab: String) {
        _uiState.update { it.copy(tabSelected = tab) }
    }

    init {
        reset()
    }

    private fun reset() {
        _uiState.update { it.copy() }
    }
}