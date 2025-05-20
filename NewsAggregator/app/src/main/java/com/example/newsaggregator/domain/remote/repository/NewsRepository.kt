package com.example.newsaggregator.domain.remote.repository

import com.example.newsaggregator.domain.model.ArticleMainModel

interface NewsRepository {
    suspend fun getArticlesList(): List<ArticleMainModel>
}