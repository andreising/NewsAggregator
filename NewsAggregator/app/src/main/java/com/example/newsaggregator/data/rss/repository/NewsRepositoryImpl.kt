package com.example.newsaggregator.data.rss.repository

import com.example.newsaggregator.data.rss.api.RssFeedApi
import com.example.newsaggregator.data.rss.mapper.toArticleMainModel
import com.example.newsaggregator.domain.model.ArticleMainModel
import com.example.newsaggregator.domain.remote.repository.NewsRepository

class NewsRepositoryImpl(private val api: RssFeedApi): NewsRepository {
    override suspend fun getArticlesList(): List<ArticleMainModel> {
        return api.getRss().channel.items.map { it.toArticleMainModel() }
    }
}