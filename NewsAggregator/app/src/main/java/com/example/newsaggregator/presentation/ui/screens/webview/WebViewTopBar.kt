package com.example.newsaggregator.presentation.ui.screens.webview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.kevinnzou.web.WebViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewTopBar(state: WebViewState, onBack: () -> Unit) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = state.pageTitle ?: "",
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Companion.Ellipsis,
                )
            },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        if (state.isLoading) {
            LinearProgressIndicator(modifier = Modifier.Companion.fillMaxWidth())
        }
    }
}