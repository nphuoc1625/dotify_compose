package com.example.dotify_kotlin.features.playlist.data.datasources

import com.example.dotify_kotlin.features.core.data.models.PageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaylistApi {


    @GET("me/playlists")
    suspend fun  getCurrentUserPlaylists(
        @Query("limit") limit : Int?,
        @Query("offset") offset : Int?  ) : PageResponse

}