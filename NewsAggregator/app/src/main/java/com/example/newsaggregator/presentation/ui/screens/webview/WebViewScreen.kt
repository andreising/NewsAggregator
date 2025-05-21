package com.example.newsaggregator.presentation.ui.screens.webview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kevinnzou.web.WebView
import com.kevinnzou.web.rememberWebViewState

@Composable
fun WebViewScreen() {
    val viewModel: WebViewScreenViewModel = hiltViewModel()
    val url by viewModel.url.collectAsState()


    url?.let { notNullUrl ->

        val state = rememberWebViewState(notNullUrl)

        Box(modifier = Modifier.fillMaxSize()) {
            WebView(
                state,
                onCreated = { it.settings.javaScriptEnabled = true })
        }
    } ?: Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}