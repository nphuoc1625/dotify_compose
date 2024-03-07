package com.example.dotify_kotlin.features.core.data.models

import PlaylistDTO
import kotlinx.serialization.Serializable

@Serializable
data class PageResponse (
    val href: String,
    val limit: Int,
    val next: String?,
    val offset: Int,
    val previous: String?,
    val total: Int,
    val items: List<PlaylistDTO>
)