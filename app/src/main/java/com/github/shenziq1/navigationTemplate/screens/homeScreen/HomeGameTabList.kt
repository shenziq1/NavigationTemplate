package com.github.shenziq1.navigationTemplate.screens.homeScreen

import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController
import com.github.shenziq1.navigationTemplate.models.HomeGameTabData
import com.github.shenziq1.navigationTemplate.uiStates.HomeUiState
import com.github.shenziq1.navigationTemplate.viewModels.HomeViewModel

fun LazyListScope.homeGameTabScreen(
    navController: NavHostController,
    homeUiState: HomeUiState,
    viewModel: HomeViewModel
) {
    items(HomeGameTabData.data){
        HomeGameTabCardView(homeGameTabCard = it, navController = navController)
    }
}

