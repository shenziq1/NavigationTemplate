package com.github.shenziq1.finalnavigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun updateCount(){
        _uiState.update { it.copy(counter = it.counter+1) }
    }

    fun updateTab(tab:Int){
        _uiState.update { it.copy( tab = tab) }
    }

    init{
        reset()
    }

    private fun reset(){
        _uiState.update { it.copy() }
    }
}