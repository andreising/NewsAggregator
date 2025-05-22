package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.domain.local.room.usecases.GetArticleListLocalUseCase
import com.example.newsaggregator.domain.local.room.usecases.SaveArticlesUseCase
import com.example.newsaggregator.domain.remote.usecases.GetArticlesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getArticleUseCase: GetArticlesListUseCase,
    private val getArticlesListLocalUseCase: GetArticleListLocalUseCase,
    private val saveArticlesListUseCase: SaveArticlesUseCase
) : ViewModel() {

    private val _mainScreenEventState = mutableStateOf<MainScreenEvent>(MainScreenEvent.Loading)
    val mainScreenEventState: State<MainScreenEvent> = _mainScreenEventState

    private fun setScreenState(state: MainScreenEvent) {
        _mainScreenEventState.value = state
    }

    fun loadNews() {
        viewModelScope.launch {
            setScreenState(MainScreenEvent.Loading)
            val operationResult = getArticleUseCase.invoke()
            if (operationResult.isSuccess) {
                operationResult.getOrNull()?.let {
                    launch {
                        saveArticlesListUseCase.invoke(it)
                    }
                    setScreenState(MainScreenEvent.Success(it))
                }
            } else {
                setScreenState(
                    MainScreenEvent.Error(
                        message = "Network error, try again",
                        localList = getArticlesListLocalUseCase.invoke()
                    )
                )
            }
        }
    }

    init {
        loadNews()
    }
}