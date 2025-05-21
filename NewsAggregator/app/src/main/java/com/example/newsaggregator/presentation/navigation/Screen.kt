package com.example.newsaggregator.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
    data object WebViewScreen: Screen("webview_screen")
}