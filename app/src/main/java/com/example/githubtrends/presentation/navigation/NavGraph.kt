package com.example.githubtrends.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.githubtrends.presentation.repo_listings.RepoListingsScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        route = "root",
        startDestination = Screen.RepoListingsScreen.route
    ) {
        // Define all roots here

        composable(route = Screen.RepoListingsScreen.route) {
            RepoListingsScreen(navController = navController)
        }

        composable(
            route = Screen.RepoDetailsScreen.route + "/{$ARG_REPO_ID}",
            arguments = listOf(
                navArgument(ARG_REPO_ID) {
                    type = NavType.LongType
                    nullable = false
                }
            )
        ){
            val repoId = it.arguments?.get(ARG_REPO_ID) as Long

        }

    }

}