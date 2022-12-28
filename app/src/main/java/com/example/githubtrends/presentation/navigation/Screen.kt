package com.example.githubtrends.presentation.navigation

const val ARG_REPO_ID = "id"

sealed class Screen(val route : String){
    object RepoListingsScreen : Screen("repo_listings")
    object RepoDetailsScreen : Screen("repo_details")
}
