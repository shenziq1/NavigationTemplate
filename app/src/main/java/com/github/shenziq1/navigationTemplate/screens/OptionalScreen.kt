package com.github.shenziq1.navigationTemplate.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.github.shenziq1.navigationTemplate.Screen

@Composable
fun OptionalScreen(navController: NavHostController) {
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
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
                text = "Optional",
                color = MaterialTheme.colors.secondary,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun OptionalScreenPreview(){
//    DetailScreen(navController = rememberNavController())
//}