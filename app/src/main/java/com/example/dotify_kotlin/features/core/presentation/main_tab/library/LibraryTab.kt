package com.example.dotify_kotlin.features.core.presentation.main_tab.library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dotify_kotlin.features.core.presentation.main_tab.library.components.LibraryAppbar
import com.example.dotify_kotlin.features.core.presentation.main_tab.library.components.PlaylistItem
import com.example.dotify_kotlin.features.playlist.domain.PlaylistEntity
import com.example.dotify_kotlin.features.playlist.presentation.playlistDetail.PlaylistDetailScreenArg
import com.example.dotify_kotlin.routes.navigatePlaylistDetail
import com.example.dotify_kotlin.theme.Dotify_kotlinTheme
import org.koin.compose.rememberKoinInject

@Composable
fun LibraryTab(
    navController: NavController
){
    val viewModel =  rememberKoinInject<LibraryVM>()
    val playlist by viewModel.personalPlaylist.collectAsState()

    Scaffold(
        topBar = {
            LibraryAppbar(imageUrl = "",
                onSearchTap = { /*TODO*/ },
                onAddTap = {})
        },
        content = {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(darkColorScheme().surface) ){
                        PlaylistList(
                            onItemClick = {
                                navController.navigatePlaylistDetail(PlaylistDetailScreenArg(it.id))
                            },
                            playlist)
                    }

        }

    )


}

@Composable
fun PlaylistList(
    onItemClick: (PlaylistEntity) ->Unit,
    playlists: List<PlaylistEntity>
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(darkColorScheme().surface)
    ) {
        Column {
           
            LazyColumn(
                Modifier
                    .padding(horizontal = 16.dp, vertical = 16.dp)
                    .defaultMinSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),

            ){

                items(
                    playlists.size,
                ){
                         val   playlist = playlists[it]
                        PlaylistItem(
                            onItemClick = {
                              onItemClick(playlist)
                            },
                            imageUrl = playlist.imageUrl,
                            name = playlist.name,
                            createdBy = playlist.owner
                        )

                }

            }
        }
    }
}




@Composable
@Preview
private fun LibraryTabPreview(){
    Dotify_kotlinTheme {
        PlaylistList(
           onItemClick =  {},
            playlists = generateSequence(1) { it + 1 }
                .take(15)
                .toList()
                .map { PlaylistEntity(
                    name = "This Thinh Suy",
                    imageUrl = "",
                    id = "",
                    owner = ""
                ) }
        )
    }
//    PlaylistItem(
//        imageUrl = "https://i.scdn.co/image/ab67616d00004851b315e8bb7ef5e57e9a25bb0f",
//        name = "99%",
//        createdBy = "Spotify"
//    )
}