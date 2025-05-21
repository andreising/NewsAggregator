package com.example.newsaggregator.domain.local.room.repository

import com.example.newsaggregator.domain.model.ArticleMainModel

interface NewsLocalRepository {
    suspend fun saveNewsList(list: List<ArticleMainModel>)
    suspend fun getNewsList(): List<ArticleMainModel>
}