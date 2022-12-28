package com.example.githubtrends.util

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences>
        by preferencesDataStore(name = "github_trends_data_store")

@Singleton
class DataStoreUtil @Inject constructor(val app: Application) {

    suspend fun getApiCallTimestamp(): Long? {
        return app.dataStore.data.first()[TIMESTAMP_LAST_API_CALL]
    }

    suspend fun saveApiCallTimestamp(timestamp: Long) {
        app.dataStore.edit { preferences ->
            preferences[TIMESTAMP_LAST_API_CALL] = timestamp
        }
    }

    suspend fun clear() {
        app.dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val TIMESTAMP_LAST_API_CALL = longPreferencesKey("timestamp_last_api_call")
    }

}