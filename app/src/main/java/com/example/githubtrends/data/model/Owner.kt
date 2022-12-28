package com.example.githubtrends.data.model

import com.squareup.moshi.Json

data class Owner(
    @field:Json(name = "login")
    val name: String,
    @field:Json(name = "avatar_url")
    val avatar: String,
)