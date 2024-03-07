package com.example.dotify_kotlin.network

import com.example.dotify_kotlin.features.auth.presentation.AuthViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitInstance(
    private val  authViewModel: AuthViewModel
)   {
    private val retrofit: Retrofit

    init {
          val json = Json {
              ignoreUnknownKeys = true
              prettyPrint = true }

        val loggingInterceptor = AccessTokenInterceptor(authViewModel)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    companion object {
        private const val BASE_URL = "https://api.spotify.com/v1/"


    }

    fun <T> createApi(apiClass: Class<T>): T {
        return retrofit.create(apiClass)
    }
}
