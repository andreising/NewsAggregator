package com.example.newsaggregator.data.rss.api

import com.example.newsaggregator.data.rss.dto.RssDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RssFeedApi {
    @GET("/{query}/rss")
    suspend fun getRss(
        @Path("query") query: String = "international"
    ): RssDto
}