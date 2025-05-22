package com.example.newsaggregator.presentation.ui.screens.webview

import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsaggregator.presentation.ui.utils.MaxSizeLoadingIndicator


@Composable
fun WebViewScreen(onBack: () -> Unit) {
    val viewModel: WebViewScreenViewModel = hiltViewModel()
    val url by viewModel.url.collectAsState()

    url?.let { notNullUrl ->
        WebViewScaffold(notNullUrl, onBack)
    } ?: MaxSizeLoadingIndicator()
}