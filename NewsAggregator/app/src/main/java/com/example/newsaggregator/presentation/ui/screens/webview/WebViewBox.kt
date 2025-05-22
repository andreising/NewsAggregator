package com.example.newsaggregator.presentation.ui.screens.webview

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kevinnzou.web.WebView
import com.kevinnzou.web.WebViewState

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewBox(state: WebViewState, padding: PaddingValues) {
    Box(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(padding)
    ) {
        WebView(
            state = state,
            onCreated = { it.settings.javaScriptEnabled = true }
        )
    }
}