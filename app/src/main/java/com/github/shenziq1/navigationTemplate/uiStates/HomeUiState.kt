package com.github.shenziq1.navigationTemplate.uiStates

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.github.shenziq1.navigationTemplate.viewModels.CardViewModel

data class HomeUiState(
    val tabSelected: String = "Game",
    val homeCounter: Int = 0,
    val optionalCounter: Int = 0,
    val gameCardUiStates: MutableList<CardViewModel> = mutableStateListOf()
)