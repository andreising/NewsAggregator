package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.newsaggregator.R
import com.example.newsaggregator.domain.model.ArticleMainModel

@Composable
fun ArticlesList(
    articles: List<ArticleMainModel>,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    clearTextField: () -> Unit,
    onClick: (ArticleMainModel) -> Unit
) {
    val context = LocalContext.current
    val filteredArticles = remember(articles, searchQuery) {
        articles.filter {
            it.title.contains(searchQuery, ignoreCase = true)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            label = { Text(stringResource(R.string.search_by_title)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            trailingIcon = {
                if (searchQuery.isNotBlank()) IconButton(onClick = clearTextField) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                }
            },
            maxLines = 1
        )

        if (filteredArticles.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(R.string.nothing_found),
                    modifier = Modifier.align(Center),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredArticles) { article ->
                    ArticleCard(article, context) {
                        onClick(article)
                    }
                }
            }
        }
    }
}