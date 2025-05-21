package com.example.newsaggregator.domain.model

data class ArticleMainModel(
    val title: String,
    val link: String,
    val description: String,
    val tags: List<String>,
    val pubDate: String,
    val imageUrl: String?,
    val creator: String,
    val date: String
)
