package com.github.shenziq1.finalnavigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun App(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val items = listOf<String>("home_screen", "login_screen", "signup_screen")
    Scaffold(bottomBar = {if (items.contains(currentDestination?.route))
        BottomNavigationBar(navController = navController)
    }) {
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf<String>("HOME", "LOGIN", "SIGNUP")
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any() {
                    it.route == item
                } == true,
                onClick = {
                    navController.navigate(item) {
                        popUpTo(item)
                    }
                },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "null"
                    )
                },
                label = { Text(text = item) }
            )
        }
    }
}