package com.github.shenziq1.navigationTemplate.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.clickable {
                    navController.navigate("HOME") {
                        popUpTo("HOME") {
                            inclusive = true
                        }
                    }
                },
                text = "Login",
                color = MaterialTheme.colors.secondary,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

//@Composable
//@Preview(showBackground = true)
//fun LoginScreenPreview() {
//    LoginScreen(navController = rememberNavController())
//}