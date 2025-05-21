package com.example.newsaggregator.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.domain.local.room.usecases.GetArticleListLocalUseCase
import com.example.newsaggregator.domain.local.room.usecases.SaveArticlesUseCase
import com.example.newsaggregator.domain.model.ArticleMainModel
import com.example.newsaggregator.domain.remote.usecases.GetArticlesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getArticleUseCase: GetArticlesListUseCase,
    private val getArticlesListLocalUseCase: GetArticleListLocalUseCase,
    private val saveArticlesListUseCase: SaveArticlesUseCase
): ViewModel() {

    private val _articles = MutableStateFlow(emptyList<ArticleMainModel>())
    val articles: StateFlow<List<ArticleMainModel>> = _articles

    init {
        viewModelScope.launch {
            val operationResult = getArticleUseCase.invoke()
            if (operationResult.isSuccess) {
                operationResult.getOrNull()?.let {
                    launch {
                        saveArticlesListUseCase.invoke(it)
                    }
                    _articles.value = it
                }
            } else {
                _articles.value = getArticlesListLocalUseCase.invoke()
            }
        }
    }
}