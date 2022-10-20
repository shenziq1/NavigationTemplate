package com.github.shenziq1.navigationTemplate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.github.shenziq1.navigationTemplate.navGraphs.homeNavGraph
import com.github.shenziq1.navigationTemplate.navGraphs.loginNavGraph
import com.github.shenziq1.navigationTemplate.navGraphs.signUpNavGraph

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