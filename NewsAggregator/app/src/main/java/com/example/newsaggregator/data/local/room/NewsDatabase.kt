package com.example.newsaggregator.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsaggregator.data.local.room.dao.NewsLocalDao
import com.example.newsaggregator.data.local.room.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsLocalDao
}