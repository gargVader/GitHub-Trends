package com.example.githubtrends.di

import android.app.Application
import androidx.room.Room
import com.example.githubtrends.data.local.RepoDatabase
import com.example.githubtrends.data.remote.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGithubApi(): GithubApi {
        return Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesRepoDatabase(
        app: Application
    ): RepoDatabase {
        return Room.databaseBuilder(
            app,
            RepoDatabase::class.java, "repo_db"
        ).build()
    }
}