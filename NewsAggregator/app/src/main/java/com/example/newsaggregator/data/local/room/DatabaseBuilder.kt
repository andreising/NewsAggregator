package com.example.newsaggregator.data.local.room

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    fun buildDatabase(context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NewsDatabase::class.java,
            "news_database"
        ).build()
    }
}