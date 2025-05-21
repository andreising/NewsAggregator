package com.example.newsaggregator.domain.local.room.usecases

import com.example.newsaggregator.domain.local.room.repository.NewsLocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetArticleListLocalUseCase @Inject constructor(
    private val repository: NewsLocalRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        repository.getNewsList()
    }
}