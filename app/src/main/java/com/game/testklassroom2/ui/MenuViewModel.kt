package com.game.testklassroom2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.game.testklassroom2.ui.model.PostItemModel
import com.game.testklassroom2.domain.usecase.PostsUseCase
import com.game.testklassroom2.ui.mapping.toItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(private val useCase: PostsUseCase) : ViewModel() {
    private var loadNextJob: Job? = null

    private val _stateFlow = MutableStateFlow<State>(State())
    val stateFlow: Flow<State> = _stateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            useCase.postFlow.collect { postList ->
                _stateFlow.update { state ->
                    state.copy(postList = postList.map {
                        it.toItemModel()
                    })
                }
            }
        }
        viewModelScope.launch {
            useCase.initialLoadPosts()
        }
    }

    fun onPageEndReached() {
        if (loadNextJob?.isActive == true) return
        loadNextJob = viewModelScope.launch {
            useCase.loadNextPosts()
        }
    }

    data class State(val postList: List<PostItemModel?> = emptyList())


}