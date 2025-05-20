package com.example.newsaggregator.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    startDestination: String,
    mainScreen: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = Screen.MainScreen.route) {
            mainScreen.invoke()
        }
    }
}