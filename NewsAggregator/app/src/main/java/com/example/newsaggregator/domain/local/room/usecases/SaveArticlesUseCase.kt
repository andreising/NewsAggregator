package com.example.newsaggregator.domain.local.room.usecases

import com.example.newsaggregator.domain.local.room.repository.NewsLocalRepository
import com.example.newsaggregator.domain.model.ArticleMainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveArticlesUseCase @Inject constructor(
    private val repository: NewsLocalRepository
){
    suspend operator fun invoke(list: List<ArticleMainModel>) = withContext(Dispatchers.IO) {
        repository.saveNewsList(list)
    }
}