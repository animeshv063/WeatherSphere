package com.example.weathersphere.data.api

import com.example.weathersphere.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("weather/current")
    suspend fun getCurrentWeather(
        @Query("city") city : String
    ): WeatherResponse
}