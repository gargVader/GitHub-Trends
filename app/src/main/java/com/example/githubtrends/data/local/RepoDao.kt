package com.example.githubtrends.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubtrends.data.model.Repo

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepoList(
        repoList : List<Repo>
    )

    @Query("DELETE FROM repo")
    suspend fun clearRepoList()

    @Query("SELECT * FROM repo ORDER BY stars DESC")
    suspend fun getAllRepos() : List<Repo>

    @Query("SELECT * FROM repo WHERE id LIKE :id")
    suspend fun getRepoInfo(id : Long) : Repo?
}