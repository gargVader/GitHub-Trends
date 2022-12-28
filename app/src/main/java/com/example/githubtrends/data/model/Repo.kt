package com.example.githubtrends.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * For the purpose of this project, a common Repo.kt class have been made.
 * For larger projects, it is advisable to have
 *  - RepoEntity.kt in local
 *  - RepoDto.kt in remote
 *  - Repo.kt in domain.model
 */
@Entity
data class Repo(
    @PrimaryKey
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "stargazers_count")
    val stars: Long,
    @field:Json(name = "forks_count")
    val forks: Long,
    @Embedded
    @field:Json(name = "owner")
    val owner: Owner,
    @field:Json(name = "html_url")
    val url: String,
)