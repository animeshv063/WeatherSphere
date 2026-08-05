package com.example.weathersphere.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(

    name = "settings"

)

object SettingsDataStore {

    val IS_CELCIUS = booleanPreferencesKey(
        "is_celsius"
    )

}