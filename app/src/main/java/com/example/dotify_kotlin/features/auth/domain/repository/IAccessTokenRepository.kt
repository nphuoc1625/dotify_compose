package com.example.dotify_kotlin.features.auth.domain.repository

import com.example.dotify_kotlin.features.auth.domain.entity.AccessToken
import kotlinx.coroutines.flow.Flow

interface IAccessTokenRepository {
    suspend fun getToken(): Flow<AccessToken?>
    suspend fun saveToken(token: AccessToken)
    suspend fun deleteToken()
}
