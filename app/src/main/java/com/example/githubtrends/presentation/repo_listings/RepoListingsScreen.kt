package com.example.githubtrends.presentation.repo_listings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RepoListingsScreen(
    navController: NavHostController,
    viewModel: RepoListingsViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = state.isRefreshing)
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { viewModel.getAllRepos() }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(state.repoList) { it ->
                RepoItem(repo = it)
            }
        }

    }


}