package com.example.dotify_kotlin.routes

import androidx.compose.animation.fadeIn
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.dotify_kotlin.features.playlist.presentation.playlistDetail.PlaylistDetailScreen
import com.example.dotify_kotlin.features.playlist.presentation.playlistDetail.PlaylistDetailScreenArg

sealed class Routes(val name: String) {
    data object PreLoadingScreen : Routes("pre_loading")
    data object MainScreen : Routes("main")
    data object LoginScreen : Routes("login")
    data object PlaylistDetail : Routes("playlist")
}

fun NavGraphBuilder.playlistDetail(){
    composable(
        Routes.PlaylistDetail.name+"/{playlist_id}",
       enterTransition = {
           fadeIn()
       } ){
        PlaylistDetailScreen(args = PlaylistDetailScreenArg(
           it.arguments?.getString("playlist_id") ?: ""
        ))
    }
}
fun NavController.navigatePlaylistDetail(
    arg: PlaylistDetailScreenArg
){
    this.navigate(Routes.PlaylistDetail.name+"/${arg.playlistId}")
}