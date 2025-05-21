package com.example.newsaggregator.domain.remote.usecases

import com.example.newsaggregator.domain.model.ArticleMainModel
import com.example.newsaggregator.domain.remote.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

class GetArticlesListUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): Result<List<ArticleMainModel>> = withContext(Dispatchers.IO) {
        try {
            Result.success(repository.getArticlesList())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}