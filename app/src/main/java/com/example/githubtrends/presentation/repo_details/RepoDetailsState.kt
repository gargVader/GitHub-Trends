package com.example.githubtrends.presentation.repo_details

import com.example.githubtrends.data.model.Repo

data class RepoDetailsState(
    // made null because didn't set default values for Repo()
    val repo: Repo? = null,
    val isLoading: Boolean = false,
)