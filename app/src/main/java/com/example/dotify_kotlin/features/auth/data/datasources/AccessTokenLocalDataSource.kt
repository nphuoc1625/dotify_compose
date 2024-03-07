package com.example.dotify_kotlin.features.auth.data.datasources

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.dotify_kotlin.features.auth.domain.entity.AccessToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date

class AccessTokenLocalDataSource(
    private val context: Context
) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "access_token")

    fun get() : Flow<AccessToken?> = context.dataStore.data
        .map { preferences ->
            preferences[TOKEN]?.let {
                AccessToken(
                    token = it,
                    createdDate = Date(preferences[CREATED_DATE] ?: 0)
                )
            }

        }

    suspend fun save(accessToken: AccessToken) {
         context.dataStore.edit { settings ->
            settings[TOKEN] = accessToken.token
             settings[CREATED_DATE] = accessToken.createdDate.time
        }
    }
    companion object {
        private val TOKEN = stringPreferencesKey("token")
        private val CREATED_DATE = longPreferencesKey("created_date")
    }
}