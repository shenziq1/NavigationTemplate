package com.github.shenziq1.finalnavigation.navGraphs

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.github.shenziq1.finalnavigation.*

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Home.route,
        route = "HOME"
    ){
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
            }, navArgument(DETAIL_ARGUMENT_KEY2) {
                type = NavType.StringType
            })
        ) {
            Log.d("args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            DetailScreen(navController)
        }

        composable(
            route = Screen.Optional.route,
            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
                defaultValue = 0
            }, navArgument(DETAIL_ARGUMENT_KEY2) {
                type = NavType.StringType
                defaultValue = "NULL"
            })
        ) {
            Log.d("args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())
            OptionalScreen(navController)
        }
    }
}
