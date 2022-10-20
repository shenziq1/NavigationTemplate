package com.github.shenziq1.finalnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.github.shenziq1.finalnavigation.navGraphs.homeNavGraph
import com.github.shenziq1.finalnavigation.navGraphs.loginNavGraph
import com.github.shenziq1.finalnavigation.navGraphs.signUpNavGraph

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "HOME",
        route = "ROOT"
    ) {
        homeNavGraph(navController)
        loginNavGraph(navController)
        signUpNavGraph(navController)
    }
}