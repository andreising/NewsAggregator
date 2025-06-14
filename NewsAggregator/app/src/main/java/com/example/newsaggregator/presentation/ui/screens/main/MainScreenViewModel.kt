package com.example.newsaggregator.presentation.ui.screens.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsaggregator.domain.local.room.usecases.GetArticleListLocalUseCase
import com.example.newsaggregator.domain.local.room.usecases.SaveArticlesUseCase
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
) : ViewModel() {

    private val _mainScreenEventState = MutableStateFlow<MainScreenEvent>(MainScreenEvent.Loading)
    val mainScreenEventState: StateFlow<MainScreenEvent> = _mainScreenEventState

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    fun onSearchQueryChange(newValue: String) {
        if (newValue.length > 20) return
        _searchQuery.value = newValue
    }

    fun clearQueryChange() {
        _searchQuery.value = ""
    }

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
}
