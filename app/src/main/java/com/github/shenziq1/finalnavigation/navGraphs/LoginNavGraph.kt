package com.github.shenziq1.finalnavigation.navGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.github.shenziq1.finalnavigation.LoginScreen
import com.github.shenziq1.finalnavigation.Screen

fun NavGraphBuilder.loginNavGraph(navController: NavHostController){
    navigation(startDestination = Screen.Login.route, route = "LOGIN"){
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }
    }
}