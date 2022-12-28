package com.example.githubtrends.domain.repository

import com.example.githubtrends.data.model.Repo
import com.example.githubtrends.util.Resource
import kotlinx.coroutines.flow.Flow


interface RepoRepository {

    suspend fun getAllRepos(
    ): Flow<Resource<List<Repo>>>

    suspend fun getRepoInfo(id: Long): Flow<Resource<Repo>>

}