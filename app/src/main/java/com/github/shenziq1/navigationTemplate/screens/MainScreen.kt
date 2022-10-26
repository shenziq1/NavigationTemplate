package com.github.shenziq1.navigationTemplate.screens

import com.github.shenziq1.navigationTemplate.R
import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.github.shenziq1.navigationTemplate.navGraphs.SetupNavGraph

@Composable
fun MainScreen(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val items = listOf<String>("home_screen", "login_screen", "signup_screen")

    Scaffold(bottomBar = {
        if (items.contains(currentDestination?.route))
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
                        popUpTo(navController.graph.findStartDestination().id){

                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }

                    currentDestination?.hierarchy?.forEach {
                        Log.d(
                            "bottomNav",
                            it.route ?: "none"
                        )
                    }
                    Log.d("bottomNav", "*********************")
                },
                icon = {
                    Icon(painter = painterResource(id = R.drawable.diamond), contentDescription = null)
                },
                label = { Text(text = item) }
            )
        }
    }
}