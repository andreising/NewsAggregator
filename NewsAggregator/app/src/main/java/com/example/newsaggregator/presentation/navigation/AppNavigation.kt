package com.example.newsaggregator.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    startDestination: String,
    mainScreen: @Composable () -> Unit,
    webViewScreen: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = Screen.MainScreen.route) {
            mainScreen.invoke()
        }

        composable(
            route = Screen.WebViewScreen.route + "?url={url}",
            arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            webViewScreen.invoke()
        }
    }
}