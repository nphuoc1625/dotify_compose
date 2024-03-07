package com.example.dotify_kotlin.features.auth.services

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.example.dotify_kotlin.features.auth.domain.entity.AccessToken
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import java.util.Calendar


class SpotifyAuth( )   {

    companion object{
       private const val REQUEST_CODE = 1337
        private const val REDIRECT_URI = "dotify://phuoc.dotify.com"
        private const val CLIENT_ID = "60be62dd777048459cf90e49c9dcc06e"
        private const val CLIENT_SECRET = "375923a2619b4695b1163deb9536b1cc"
    }

    fun handleUri(uri: Uri) : AccessToken? {
        val response :AuthorizationResponse = AuthorizationResponse.fromUri(uri);
        return when (response.type) {
            AuthorizationResponse.Type.TOKEN -> {
               AccessToken(
                    token = response.accessToken,
                    createdDate = Calendar.getInstance().time,
                )
            }
            else -> {
                null
            }
        }
    }

    fun onActivityResult(resultCode: Int,data: Intent?) : AccessToken? {
        if (resultCode == REQUEST_CODE){
            if (data != null && data.data != null){
                 return handleUri(data.data!!)
            }
        }
        return null
    }

    fun loginInBrowser(contextActivity: Activity){
        val builder =
            AuthorizationRequest.Builder(
                CLIENT_ID,
                AuthorizationResponse.Type.TOKEN,
                REDIRECT_URI
            )

        builder.setScopes(arrayOf<String?>().plus(
            SpotifyScopes.playlistScopes()))
        val request = builder.build()
         AuthorizationClient.openLoginInBrowser(contextActivity, request)
    }


    fun loginFromActivity(contextActivity: Activity){

        val builder =
          AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI);

        builder.setScopes(arrayOf<String?>().plus(
            SpotifyScopes.playlistScopes()))
        val request = builder.build()

        AuthorizationClient.openLoginActivity(contextActivity, REQUEST_CODE, request);
    }

    fun logout(contextActivity: Activity){
        AuthorizationClient.clearCookies(contextActivity)
        val builder =
            AuthorizationRequest.Builder(
                CLIENT_ID,
                AuthorizationResponse.Type.TOKEN,
                REDIRECT_URI
            )

        builder.setScopes(arrayOf<String?>().plus(
            SpotifyScopes.playlistScopes()))
        builder.setShowDialog(true)
        val request = builder.build()
        AuthorizationClient.openLoginInBrowser(contextActivity, request)
    }
}