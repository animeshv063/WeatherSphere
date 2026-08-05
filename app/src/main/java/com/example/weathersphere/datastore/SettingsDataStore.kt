package com.example.weathersphere.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.weathersphere.datastore.SettingsDataStore.IS_CELSIUS
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(

    name = "settings"

)

object SettingsDataStore {

    val IS_CELSIUS = booleanPreferencesKey(
        "is_celsius"
    )

    suspend fun saveTemperatureUnit(

        context: Context,

        isCelsius: Boolean

    ){
        context.dataStore.edit {
            it[IS_CELSIUS] = isCelsius
        }
    }

}

fun getTemperatureUnit(
    context: Context
) =
    context.dataStore.data.map {
        it[IS_CELSIUS] ?: true
    }