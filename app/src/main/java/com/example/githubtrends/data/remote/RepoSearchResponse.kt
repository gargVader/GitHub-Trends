package com.example.githubtrends.data.remote

import com.example.githubtrends.data.model.Repo
import com.squareup.moshi.Json

data class RepoSearchResponse(
    @field:Json(name = "total_count")
    val count: Long,
    @field:Json(name = "items")
    val items: List<Repo>,
)
