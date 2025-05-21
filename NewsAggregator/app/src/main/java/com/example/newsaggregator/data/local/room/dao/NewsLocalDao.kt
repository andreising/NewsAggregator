package com.example.newsaggregator.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsaggregator.data.local.room.entity.ArticleEntity

@Dao
interface NewsLocalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(news: List<ArticleEntity>)

    @Query("SELECT * FROM article")
    suspend fun getAll(): List<ArticleEntity>
}