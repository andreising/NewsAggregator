package com.example.newsaggregator.presentation.ui.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MaxSizeLoadingIndicator() {
    Box(modifier = Modifier.Companion.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.Companion.align(Alignment.Companion.Center))
    }
}