package com.example.dotify_kotlin.features.auth.presentation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dotify_kotlin.features.auth.domain.entity.AccessToken
import com.example.dotify_kotlin.features.auth.domain.repository.IAccessTokenRepository
import com.example.dotify_kotlin.features.auth.services.SpotifyAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import java.util.Calendar

class AuthViewModel(
    private  val authService: SpotifyAuth,
    private val tokenRepository: IAccessTokenRepository
) : ViewModel() {
    private  val _currentToken = MutableStateFlow<AccessToken?>(null)
    val currentToken = _currentToken.asStateFlow()
    private var onAuthCompleteListener: ((accessToken : AccessToken) -> Unit)? = null



    fun loginFromWeb(contextActivity: Activity ) {
        authService.loginInBrowser(contextActivity)
    }

//    fun loginFromActivity(contextActivity: Activity ) {
//        authService.loginFromActivity(contextActivity)
//
//    }

    fun handleResultFromWeb(uri : Uri){
        val accessToken = authService.handleUri(uri)
        if (accessToken != null){
            loginSuccess(accessToken)
        }
    }

    fun handleResultFromActivity(resultCode: Int,data: Intent?){
        val accessToken = authService.onActivityResult(resultCode,data)
        if (accessToken != null){
            loginSuccess(accessToken)
        }
    }
    private fun loginSuccess(accessToken: AccessToken){
        viewModelScope.launch {
            tokenRepository.saveToken(accessToken)
        }
        _currentToken.value = accessToken
        onAuthCompleteListener?.invoke(_currentToken.value!!)
    }
    fun checkCurrentUser(contextActivity: Activity){
        viewModelScope.launch {
            tokenRepository.getToken()
                .catch {
                }
                .collect {
                    Log.d("debug"," current token: ${_currentToken.value?.token ?:"null"}")
                    if(it != null){
                        if (isTokenExpired(it)){
                            authService.loginInBrowser(contextActivity    )
                        }else{
                            _currentToken.value = it

                        }
                    }
                    else{
                        _currentToken.value = null
                    }

                }
        }


    }

    private fun isTokenExpired(accessToken: AccessToken) : Boolean{
        val tokenCreatedDate = accessToken.createdDate.time
        val currentDate = Calendar.getInstance().time.time
        return currentDate - tokenCreatedDate >3600
    }

    fun setOnAuthCompleteListener(listener: (accessToken : AccessToken?) -> Unit){
        onAuthCompleteListener = listener
    }

    fun setActivity(contextActivity: Activity){

    }
}