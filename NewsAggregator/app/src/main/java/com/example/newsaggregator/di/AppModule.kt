package com.example.newsaggregator.di

import android.content.Context
import com.example.newsaggregator.data.local.room.DatabaseBuilder
import com.example.newsaggregator.data.local.room.NewsDatabase
import com.example.newsaggregator.data.local.room.repository.NewsLocalRepositoryImpl
import com.example.newsaggregator.data.rss.api.RssFeedApi
import com.example.newsaggregator.data.rss.repository.NewsRepositoryImpl
import com.example.newsaggregator.data.rss.utils.RetrofitProvider
import com.example.newsaggregator.domain.local.room.repository.NewsLocalRepository
import com.example.newsaggregator.domain.remote.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit() = RetrofitProvider.getRetrofitInstance()

    @Provides
    @Singleton
    fun provideNewsDataBase(@ApplicationContext context: Context) =
        DatabaseBuilder.buildDatabase(context)

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit) = retrofit.create(RssFeedApi::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(api: RssFeedApi): NewsRepository = NewsRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideNewsLocalRepository(database: NewsDatabase): NewsLocalRepository =
        NewsLocalRepositoryImpl(database.newsDao())
}