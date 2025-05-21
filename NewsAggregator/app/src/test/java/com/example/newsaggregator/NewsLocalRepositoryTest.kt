package com.example.newsaggregator

import com.example.newsaggregator.data.local.room.dao.NewsLocalDao
import com.example.newsaggregator.data.local.room.entity.ArticleEntity
import com.example.newsaggregator.data.local.room.mappers.toEntity
import com.example.newsaggregator.data.local.room.mappers.toModel
import com.example.newsaggregator.data.local.room.repository.NewsLocalRepositoryImpl
import com.example.newsaggregator.domain.local.room.repository.NewsLocalRepository
import com.example.newsaggregator.domain.model.ArticleMainModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class NewsLocalRepositoryImplTest {

    private lateinit var dao: NewsLocalDao
    private lateinit var repository: NewsLocalRepository

    @Before
    fun setup() {
        dao = mockk(relaxed = true)
        repository = NewsLocalRepositoryImpl(dao)
    }

    @Test
    fun `saveNewsList calls insertAll with mapped entities`() = runTest {
        val articles = listOf(
            ArticleMainModel("title", "link", "desc", listOf("tag1", "tag2"), "date", "img", "creator", "rawDate")
        )

        repository.saveNewsList(articles)

        val expected = articles.map { it.toEntity() }

        coVerify(exactly = 1) { dao.insertAll(expected) }
    }

    @Test
    fun `getNewsList returns mapped list from dao`() = runTest {
        val entities = listOf(
            ArticleEntity("link", "title", "desc", "tag1;tag2", "date", "creator", "raw_date")
        )

        coEvery { dao.getAll() } returns entities

        val result = repository.getNewsList()

        assertEquals(entities.map { it.toModel() }, result)
    }
}