package com.github.shenziq1.finalnavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {

    val homeUiState by viewModel.uiState.collectAsState()

    val tabs = listOf(0, 1)
    Scaffold() {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

            item {
                TabRow(selectedTabIndex = homeUiState.tab) {
                    tabs.forEachIndexed() { index, tab ->
                        Tab(selected = index == homeUiState.tab,
                            onClick = {
                                 viewModel.updateTab(tab)
                            }) {
                            Text(text = tab.toString(), fontSize = 40.sp)
                        }
                    }
                }
            }

            item {
                when (homeUiState.tab) {
                    0 -> Text(
                        modifier = Modifier.clickable {
                            navController.navigate(route = Screen.Detail.passNameId(5, "apple"))
                        },
                        text = "Home",
                        color = MaterialTheme.colors.primary,
                        fontSize = MaterialTheme.typography.h3.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                    1 -> Text(
                        modifier = Modifier.clickable {
                            navController.navigate(route = Screen.Optional.passNameId())
                        },
                        text = "Optional",
                        color = MaterialTheme.colors.primary,
                        fontSize = MaterialTheme.typography.h3.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            items(10) {
                Text(
                    text = homeUiState.counter.toString(),
                    fontSize = 80.sp,
                    modifier = Modifier.clickable { viewModel.updateCount() })
            }
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun HomeScreenPreview(){
//    HomeScreen(navHostController = rememberNavController())
//}