package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.newsaggregator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenTopBar(onRefresh: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.latest_news),
                style = MaterialTheme.typography.titleLarge
            )
        },
        actions = {
            IconButton(onClick = onRefresh) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
            }
        }
    )
}