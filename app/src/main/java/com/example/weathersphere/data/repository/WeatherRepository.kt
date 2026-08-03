package com.example.weathersphere.data.repository

import com.example.weathersphere.data.api.RetrofitInstance
import com.example.weathersphere.data.local.FavoriteCity
import com.example.weathersphere.data.local.FavoriteCityDao
import com.example.weathersphere.data.model.WeatherResponse

class WeatherRepository(
    private val favoriteCityDao: FavoriteCityDao
) {

    suspend fun getCurrentWeather(city: String): WeatherResponse {
        return RetrofitInstance.api.getCurrentWeather(city)
    }

    suspend fun insertFavorite(city: FavoriteCity) {
        favoriteCityDao.insertCity(city)
    }

    suspend fun deleteFavorite(city: FavoriteCity) {
        favoriteCityDao.deleteCity(city)
    }

    suspend fun getAllFavorites(): List<FavoriteCity> {
        return favoriteCityDao.getAllCities()
    }
}