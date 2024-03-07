package com.example.dotify_kotlin.network

import com.example.dotify_kotlin.features.auth.presentation.AuthViewModel
import okhttp3.Interceptor
import okhttp3.Response

class AccessTokenInterceptor(
    private val authViewModel: AuthViewModel
)  : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val authToken = authViewModel.currentToken.value?.token

        var request = chain.request()

        request = request.newBuilder()
            .addHeader("Authorization", "Bearer $authToken")
            .build()

//        println("Request: ${request.method} ${request.url}")
//        println("Headers: ${request.headers}")
//        println("Body: ${request.body}")


        val response = chain.proceed(request)
//        println("Response: ${response.code} ${response.message}")
//        println("Response Headers: ${response.headers}")
//        println("Body: ${response.body.toString()}")

        return response
    }
}