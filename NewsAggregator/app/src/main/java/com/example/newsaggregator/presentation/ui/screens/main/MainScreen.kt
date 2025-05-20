package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel()
    Text("MainScreen")
}