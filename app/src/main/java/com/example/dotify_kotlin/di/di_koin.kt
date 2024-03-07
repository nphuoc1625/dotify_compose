package com.example.dotify_kotlin.di

import com.example.dotify_kotlin.features.playlist.data.datasources.PlaylistApi
import PlaylistRepositoryImp
import com.example.dotify_kotlin.features.auth.presentation.AuthViewModel
import com.example.dotify_kotlin.features.auth.services.SpotifyAuth
import com.example.dotify_kotlin.features.auth.data.datasources.AccessTokenLocalDataSource
import com.example.dotify_kotlin.features.auth.data.repository.AccessTokenRepository
import com.example.dotify_kotlin.features.auth.domain.repository.IAccessTokenRepository
import com.example.dotify_kotlin.network.RetrofitInstance
import com.example.dotify_kotlin.features.core.presentation.main_tab.library.LibraryVM
import com.example.dotify_kotlin.features.playlist.domain.PlaylistRepository
import org.koin.dsl.module


val myModule = module {


    //Retrofit DI
    single<AccessTokenLocalDataSource> { AccessTokenLocalDataSource(get()) }
    single<IAccessTokenRepository> { AccessTokenRepository(get()) }
    single<AuthViewModel> { AuthViewModel(authService = get(), tokenRepository =  get () ) }

    single { RetrofitInstance( get()) }

    //Api
    factory<PlaylistApi> {get<RetrofitInstance>().createApi(PlaylistApi::class.java)  }

    //Data Sources

    // Repo

    single<PlaylistRepository> { PlaylistRepositoryImp(get()) }

    //Services
    single<SpotifyAuth> { SpotifyAuth()  }


    //view-model

    factory<LibraryVM> { LibraryVM(get() ) }
//    viewModel { AuthViewModel(authService = get(), tokenRepository =  get () ) }
    // Define the class that depends on MyDependency

}