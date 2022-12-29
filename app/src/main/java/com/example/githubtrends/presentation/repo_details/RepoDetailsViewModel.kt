package com.example.githubtrends.presentation.repo_details

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrends.domain.repository.RepoRepository
import com.example.githubtrends.presentation.navigation.ARG_REPO_ID
import com.example.githubtrends.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoDetailsViewModel @Inject constructor(
    private val repository: RepoRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var state by mutableStateOf(RepoDetailsState())

    init {
        getRepoInfo()
    }

    private fun getRepoInfo() {
        viewModelScope.launch {
            val repoId = savedStateHandle.get<Long>(ARG_REPO_ID) ?: return@launch
            repository.getRepoInfo(repoId).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data != null) {
                            state = state.copy(repo = result.data)
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }

                    is Resource.Error -> {
                        Log.d("Girish", "getRepoInfo: error ${result.message}")
                    }
                }
            }
        }
    }


}