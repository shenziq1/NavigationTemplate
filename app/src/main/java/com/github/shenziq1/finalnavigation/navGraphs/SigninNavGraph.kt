package com.github.shenziq1.finalnavigation.navGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.github.shenziq1.finalnavigation.Screen
import com.github.shenziq1.finalnavigation.SignupScreen

fun NavGraphBuilder.signUpNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Login.route, route = "SIGNUP") {
        composable(
            route = Screen.Login.route
        ) {
            SignupScreen(navController = navController)
        }
    }
}