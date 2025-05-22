package com.example.newsaggregator.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.newsaggregator.presentation.navigation.AppNavigation
import com.example.newsaggregator.presentation.navigation.Screen
import com.example.newsaggregator.presentation.ui.screens.main.MainScreen
import com.example.newsaggregator.presentation.ui.screens.webview.WebViewScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            AppNavigation(
                navHostController = navHostController,
                startDestination = Screen.MainScreen.route,
                mainScreen = { MainScreen(navHostController) },
                webViewScreen = { WebViewScreen{ navHostController.popBackStack() } }
            )
        }
    }
}