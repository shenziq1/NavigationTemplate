package com.github.shenziq1.navigationTemplate.screens.homeScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.github.shenziq1.navigationTemplate.viewModels.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val homeUiState by viewModel.uiState.collectAsState()

    val tabs = listOf("Game", "Follow")
    Scaffold() {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

            item {
                TabRow(selectedTabIndex = tabs.indexOf(homeUiState.tabSelected)) {
                    tabs.forEachIndexed() { index, tab ->
                        Tab(selected = index == tabs.indexOf(homeUiState.tabSelected),
                            onClick = {
                                viewModel.updateTabSelected(tab)
                            }) {
                            Text(text = tab, fontSize = 40.sp)
                        }
                    }
                }
            }

            when (homeUiState.tabSelected) {
                "Game" -> {
                    homeGameTabScreen(navController, homeUiState, viewModel)
                }
                "Follow" -> {
                    homeFollowTabScreen(navController, homeUiState, viewModel)
                }
            }
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun HomeScreenPreview(){
//    HomeScreen(navHostController = rememberNavController())
//}