package com.example.githubtrends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.githubtrends.presentation.navigation.NavGraph
import com.example.githubtrends.ui.theme.GithubTrendsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GithubTrendsTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}