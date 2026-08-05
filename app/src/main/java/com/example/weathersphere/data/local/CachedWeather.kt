package com.example.weathersphere.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "cached_weather")
data class CachedWeather(
    @PrimaryKey
    val id: Int,
    val city: String,
    val temperature: Double
)