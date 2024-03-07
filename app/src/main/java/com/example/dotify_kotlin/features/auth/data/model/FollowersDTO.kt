package com.example.dotify_kotlin.features.auth.data.model

import kotlinx.serialization.Serializable

@Serializable
data class FollowersDTO(
    val href: String?,
    val total: Int?
)