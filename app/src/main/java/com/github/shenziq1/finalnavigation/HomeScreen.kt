package com.github.shenziq1.finalnavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    var tabTimes by remember{ mutableStateOf(0)}
    val tabs = listOf("1", "2")
    Scaffold() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed() { index, tab ->
                    Tab(selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index
                        }) {
                        Text(text = tab, fontSize = 40.sp)
                    }
                }
            }

            when (selectedTabIndex){
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

            Text(text = tabTimes.toString(), fontSize = 40.sp, modifier = Modifier.clickable { tabTimes += 1 })

        }




//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Column(verticalArrangement = Arrangement.SpaceBetween) {
//
//
//            }
//
//        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun HomeScreenPreview(){
//    HomeScreen(navHostController = rememberNavController())
//}