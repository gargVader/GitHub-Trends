package com.example.githubtrends.data.remote

import com.example.githubtrends.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/*
https://api.github.com/search/repositories?q=""+language:kotlin&pushed:>2022-12-19
 */
interface GithubApi {

    @Headers("Authorization: Bearer $AUTH_TOKEN")
    @GET("search/repositories?q={query}+language:{language}&pushed:>{date}")
    suspend fun getAllRepos(
        @Path("date") date: String,
        @Path("query") query: String = DEFAULT_QUERY,
        @Path("language") language: String = DEFAULT_LANGUAGE,
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