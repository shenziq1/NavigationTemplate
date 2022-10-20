package com.github.shenziq1.navigationTemplate.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.shenziq1.navigationTemplate.Screen

@Composable
fun DetailScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(topBar = {
        TopAppBar() {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "null",
                Modifier.clickable {
                    navController.popBackStack()
                }
            )
        }
    }) {
        val detail = navBackStackEntry?.arguments?.getInt("id")
            .toString() + "  " + navBackStackEntry?.arguments?.getString("name")
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                        }
                    }
                },
                text = detail,
                color = MaterialTheme.colors.secondary,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun DetailScreenPreview(){
//    DetailScreen(navController = rememberNavController())
//}