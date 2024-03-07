package com.example.dotify_kotlin.features.auth.data.repository

import com.example.dotify_kotlin.features.auth.data.datasources.AccessTokenLocalDataSource
import com.example.dotify_kotlin.features.auth.domain.entity.AccessToken
import com.example.dotify_kotlin.features.auth.domain.repository.IAccessTokenRepository
import kotlinx.coroutines.flow.Flow

class AccessTokenRepository(
    private val localDataSource: AccessTokenLocalDataSource
) : IAccessTokenRepository {

    override suspend fun getToken(): Flow<AccessToken?> {
        return localDataSource.get()
    }

    override suspend fun saveToken(token: AccessToken) {
        localDataSource.save(token)
    }

    override suspend fun deleteToken() {
        TODO("Not yet implemented")
    }
}