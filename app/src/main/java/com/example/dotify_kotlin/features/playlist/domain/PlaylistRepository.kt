package com.example.dotify_kotlin.features.playlist.domain

interface PlaylistRepository {
    suspend fun getCurrentUserPlaylists() : List<PlaylistEntity>?

    suspend fun getPlaylist() : List<PlaylistEntity>?


}