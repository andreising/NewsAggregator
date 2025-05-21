package com.example.newsaggregator

import com.example.newsaggregator.data.rss.api.RssFeedApi
import com.example.newsaggregator.data.rss.repository.NewsRepositoryImpl
import com.example.newsaggregator.domain.remote.repository.NewsRepository
import com.example.newsaggregator.domain.remote.usecases.GetArticlesListUseCase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.test.runTest
import retrofit2.Retrofit
import nl.adaptivity.xmlutil.serialization.XML
import okhttp3.MediaType.Companion.toMediaType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetArticlesListUseCaseIntegrationTest {

    private lateinit var api: RssFeedApi
    private lateinit var repository: NewsRepository
    private lateinit var useCase: GetArticlesListUseCase

    @Before
    fun setup() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.theguardian.com")
            .addConverterFactory(
                XML.asConverterFactory(
                    "application/xml; charset=UTF8".toMediaType()
                )
            )
            .build()

        api = retrofit.create(RssFeedApi::class.java)
        repository = NewsRepositoryImpl(api)
        useCase = GetArticlesListUseCase(repository)
    }

    @Test
    fun `invoke returns real first article as expected`() = runTest {
        val result = useCase.invoke()

        assertTrue(result.getOrNull()?.isNotEmpty() == true)

        val first = result.getOrNull()?.first()

        assertEquals(
            "I’m taking beta blockers for my anxiety – and so are many of my friends. Is that a problem?",
            first?.title
        )
        assertEquals(
            "https://www.theguardian.com/lifeandstyle/2025/may/20/i-am-taking-beta-blockers-for-my-anxiety-and-so-are-many-of-my-friends-is-that-a-problem",
            first?.link
        )
        assertEquals(
            "Tue, 20 May 2025 09:00:04 GMT",
            first?.pubDate
        )
    }
}