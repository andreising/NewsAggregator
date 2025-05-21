package com.example.newsaggregator.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleEntity(
    @PrimaryKey val link: String,
    val title: String,
    val description: String,
    val tags: String,
    val pubDate: String,
    val creator: String,
    val date: String
)