package com.example.githubtrends.di

import com.example.githubtrends.data.repository.RepoRepositoryImpl
import com.example.githubtrends.domain.repository.RepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepoRepository(
        repoRepository: RepoRepositoryImpl
    ): RepoRepository
}