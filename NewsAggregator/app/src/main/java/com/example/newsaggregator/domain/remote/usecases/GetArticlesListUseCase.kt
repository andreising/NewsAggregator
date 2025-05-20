package com.example.newsaggregator.domain.remote.usecases

import com.example.newsaggregator.domain.remote.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetArticlesListUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        repository.getArticlesList()
    }
}