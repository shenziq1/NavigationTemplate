package com.github.shenziq1.navigationTemplate.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.github.shenziq1.navigationTemplate.Screen
import com.github.shenziq1.navigationTemplate.uiStates.HomeUiState
import com.github.shenziq1.navigationTemplate.viewModels.HomeViewModel

fun LazyListScope.homeGameTabScreen(navController: NavHostController, homeUiState: HomeUiState, viewModel: HomeViewModel) {
    item {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.passNameId(5, "apple"))
            },
            text = "Home",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
    items(10) {
        Text(
            text = homeUiState.homeCounter.toString(),
            fontSize = 80.sp,
            modifier = Modifier.clickable { viewModel.updateHomeCount() })
    }
}