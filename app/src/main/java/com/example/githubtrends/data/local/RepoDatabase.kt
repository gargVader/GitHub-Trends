package com.example.githubtrends.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubtrends.data.model.Repo

@Database(
    entities = [Repo::class],
    version = 1,
)
abstract class RepoDatabase : RoomDatabase() {
    abstract val dao : RepoDao
}