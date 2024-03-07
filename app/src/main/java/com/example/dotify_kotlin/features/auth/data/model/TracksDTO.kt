package com.example.dotify_kotlin.features.auth.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TracksDTO (
    val href: String?,
     val total: Int?
)