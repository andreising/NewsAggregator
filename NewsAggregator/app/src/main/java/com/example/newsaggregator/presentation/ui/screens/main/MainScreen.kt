package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.newsaggregator.presentation.navigation.Screen
import com.example.newsaggregator.presentation.ui.utils.MaxSizeLoadingIndicator
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun MainScreen(navHostController: NavHostController) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val state by viewModel.mainScreenEventState

    MainScreenScaffold(
        onRefresh = { viewModel.loadNews() }
    ) {
        when (val currentState = state) {
            is MainScreenEvent.Loading -> {
                MaxSizeLoadingIndicator()
            }

            is MainScreenEvent.Success -> {
                ArticlesList(
                    currentState.list,
                    onClick = { article ->
                        val encodedUrl =
                            URLEncoder.encode(article.link, StandardCharsets.UTF_8.toString())
                        navHostController.navigate(Screen.WebViewScreen.route + "?url=$encodedUrl")
                    },
                    onSearchChange = { viewModel.onSearchQueryChange(it) },
                    searchQuery = viewModel.searchQuery.value,
                    clearTextField = { viewModel.clearQueryChange() }
                )
            }

            is MainScreenEvent.Error -> {
                Column(
                    modifier = Modifier.align(Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(currentState.message)
                    Spacer(modifier = Modifier.height(8.dp))
                    ArticlesList(
                        currentState.localList,
                        searchQuery = viewModel.searchQuery.value,
                        onSearchChange = { viewModel.onSearchQueryChange(it) },
                        clearTextField = { viewModel.clearQueryChange() }
                    ) { article ->
                        val encodedUrl =
                            URLEncoder.encode(article.link, StandardCharsets.UTF_8.toString())
                        navHostController.navigate(Screen.WebViewScreen.route + "?url=$encodedUrl")
                    }
                }
            }
        }
    }
}