package com.example.newsaggregator.presentation.ui.screens.main

import com.example.newsaggregator.domain.model.ArticleMainModel

sealed class MainScreenEvent {
    data class Success(val list: List<ArticleMainModel>): MainScreenEvent()
    data object Loading: MainScreenEvent()
    data class Error(val message: String, val localList: List<ArticleMainModel>): MainScreenEvent()
}