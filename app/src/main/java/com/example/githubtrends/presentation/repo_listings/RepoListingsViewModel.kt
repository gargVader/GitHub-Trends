package com.example.githubtrends.presentation.repo_listings

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubtrends.domain.repository.RepoRepository
import com.example.githubtrends.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoListingsViewModel @Inject constructor(
    private val repository: RepoRepository
) : ViewModel() {

    var state by mutableStateOf(RepoListingsState())

    init {
        getAllRepos()
    }

     fun getAllRepos() {
         Log.d("Girish", "getAllRepos: ")
        viewModelScope.launch {
            repository.getAllRepos().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        if (result.data != null) {
                            state = state.copy(repoList = result.data)
                        }
                    }

                    is Resource.Loading -> {
                        state = state.copy(isRefreshing = result.isLoading)
                    }

                    is Resource.Error -> {
                        Log.d("Girish", "getAllRepos: error ${result.message}")
                    }
                }
            }
        }
    }

}