package com.example.githubtrends.presentation.repo_details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RepoDetailsScreen(
    viewModel: RepoDetailsViewModel = hiltViewModel()
) {

    val state = viewModel.state

    state.repo?.let { Text(text = it.name) }

}