package com.example.dotify_kotlin.features.core.presentation.main_tab.library

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dotify_kotlin.features.playlist.domain.PlaylistEntity
import com.example.dotify_kotlin.features.playlist.domain.PlaylistRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LibraryVM(
    private  val playlistRepository: PlaylistRepository
) : ViewModel() {
   private val _personalPlaylist = MutableStateFlow<List<PlaylistEntity>>(listOf())

    val personalPlaylist: StateFlow<List<PlaylistEntity>>
        get() = _personalPlaylist
    init {
        Log.d("debug","libraryVM init")
       getPlaylist()
    }

    private fun getPlaylist(){
        viewModelScope.launch {
            _personalPlaylist.value =  playlistRepository.getCurrentUserPlaylists() ?: listOf()
//            val result =playlistRepository.getCurrentUserPlaylistsAsString()
//            Log.d("custom",result ?: "empty")
        }
    }
}