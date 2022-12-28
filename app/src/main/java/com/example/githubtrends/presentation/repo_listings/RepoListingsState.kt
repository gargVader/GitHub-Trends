package com.example.githubtrends.presentation.repo_listings

import com.example.githubtrends.data.model.Repo

data class RepoListingsState(
    val repoList: List<Repo> = emptyList(),
    val isRefreshing : Boolean = false,
)