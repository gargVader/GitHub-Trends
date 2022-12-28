package com.example.githubtrends.data.remote

import com.example.githubtrends.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

/*
https://api.github.com/search/repositories?sort=stars&q=+language:kotlin&pushed:>2022-12-19
 */
interface GithubApi {

    @Headers("Authorization: Bearer $AUTH_TOKEN")
    @GET
    suspend fun getAllRepos(
        @Url url: String
    ): RepoSearchResponse

    companion object {
        const val BASE_URL = "https://api.github.com/"
        const val PATH_SEARCH = "search/repositories"

        const val DEFAULT_LANGUAGE = "kotlin"
        const val DEFAULT_QUERY = ""

        // Add your github personal access token to local.properties as github_token
        const val AUTH_TOKEN = BuildConfig.API_KEY
    }

}