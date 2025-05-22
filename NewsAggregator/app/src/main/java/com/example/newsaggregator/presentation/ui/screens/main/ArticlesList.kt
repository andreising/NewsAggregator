package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.newsaggregator.domain.model.ArticleMainModel

@Composable
fun ArticlesList(articles: List<ArticleMainModel>, onClick: (ArticleMainModel) -> Unit) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(articles) { article ->
            ArticleCard(article, context) {
                onClick(article)
            }
        }
    }
}