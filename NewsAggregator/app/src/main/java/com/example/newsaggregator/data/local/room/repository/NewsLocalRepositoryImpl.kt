package com.example.newsaggregator.data.local.room.repository

import com.example.newsaggregator.data.local.room.dao.NewsLocalDao
import com.example.newsaggregator.data.local.room.mappers.toEntity
import com.example.newsaggregator.data.local.room.mappers.toModel
import com.example.newsaggregator.domain.local.room.repository.NewsLocalRepository
import com.example.newsaggregator.domain.model.ArticleMainModel

class NewsLocalRepositoryImpl(private val dao: NewsLocalDao): NewsLocalRepository {
    override suspend fun saveNewsList(list: List<ArticleMainModel>) {
        dao.insertAll(list.map { it.toEntity() })
    }

    override suspend fun getNewsList(): List<ArticleMainModel> {
        return dao.getAll().map { it.toModel() }
    }
}