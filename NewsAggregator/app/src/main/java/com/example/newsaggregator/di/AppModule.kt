package com.example.newsaggregator.di

import com.example.newsaggregator.data.rss.api.RssFeedApi
import com.example.newsaggregator.data.rss.repository.NewsRepositoryImpl
import com.example.newsaggregator.data.rss.utils.RetrofitProvider
import com.example.newsaggregator.domain.remote.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideNewsApi(retrofit: Retrofit) = retrofit.create(RssFeedApi::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(api: RssFeedApi): NewsRepository = NewsRepositoryImpl(api)
}