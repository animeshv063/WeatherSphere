package com.example.weathersphere.data.repository

import com.example.weathersphere.data.api.RetrofitInstance
import com.example.weathersphere.data.model.WeatherResponse

class WeatherRepository {

    suspend fun getCurrentWeather(city: String): WeatherResponse {
        return RetrofitInstance.api.getCurrentWeather(city)
    }
}