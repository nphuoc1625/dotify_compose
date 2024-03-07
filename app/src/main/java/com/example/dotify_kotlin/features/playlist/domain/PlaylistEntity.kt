package com.example.dotify_kotlin.features.playlist.domain

import com.example.dotify_kotlin.features.auth.data.model.ExternalUrlsDTO
import com.example.dotify_kotlin.features.auth.data.model.ImageDTO
import com.example.dotify_kotlin.features.auth.data.model.OwnerDTO
import com.example.dotify_kotlin.features.auth.data.model.TracksDTO



data class PlaylistEntity(
    val id: String,
    val imageUrl: String,
    val name: String,
    val owner: String,
)