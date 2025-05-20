package com.example.newsaggregator.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.domain.model.ArticleMainModel
import com.example.newsaggregator.domain.remote.usecases.GetArticlesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCase: GetArticlesListUseCase
): ViewModel() {

    private val _articles = MutableStateFlow(emptyList<ArticleMainModel>())
    val articles: StateFlow<List<ArticleMainModel>> = _articles

    init {
        viewModelScope.launch { _articles.value = useCase.invoke() }
    }
}