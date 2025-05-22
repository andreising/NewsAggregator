package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenScaffold(
    onRefresh: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    Scaffold(
        topBar = { MainScreenTopBar(onRefresh = onRefresh) },
        content = { padding ->
            Box(
                modifier = Modifier.Companion
                    .fillMaxSize()
                    .padding(padding)
            ) {
                content()
            }
        }
    )
}