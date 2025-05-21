package com.example.newsaggregator.data.local.room.mappers

import com.example.newsaggregator.data.local.room.entity.ArticleEntity
import com.example.newsaggregator.domain.model.ArticleMainModel

fun ArticleEntity.toModel(): ArticleMainModel = ArticleMainModel(
    title, link, description, tags.split(";"), pubDate, null, creator, date
)

fun ArticleMainModel.toEntity(): ArticleEntity = ArticleEntity(
    link, title, description, tags.joinToString(";"), pubDate,  creator, date
)