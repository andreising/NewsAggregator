package com.example.newsaggregator.presentation.ui.screens.webview

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.kevinnzou.web.rememberWebViewState

@Composable
fun WebViewScaffold(url: String, onBack: () -> Unit) {
    val state = rememberWebViewState(url)

    Scaffold(
        topBar = { WebViewTopBar(state, onBack) }
    ) { padding -> WebViewBox(state, padding) }
}