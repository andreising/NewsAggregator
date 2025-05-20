package com.example.newsaggregator.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import com.example.newsaggregator.domain.remote.usecases.GetArticlesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val useCase: GetArticlesListUseCase
): ViewModel() {

}