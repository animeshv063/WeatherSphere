package com.example.weathersphere.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathersphere.data.local.AppDatabase
import com.example.weathersphere.data.local.FavoriteCity
import com.example.weathersphere.data.model.WeatherResponse
import com.example.weathersphere.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = WeatherRepository(
        AppDatabase.getDatabase(getApplication()).favoriteCityDao()
    )

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState

    fun getCurrentWeather(city: String) {
        viewModelScope.launch {

            _uiState.value = WeatherUiState(isLoading = true)

            try {
                val weather = repository.getCurrentWeather(city)

                _uiState.value = WeatherUiState(
                    weather = weather
                )
            } catch (e: Exception) {
                _uiState.value = WeatherUiState(
                    error = e.message ?: "Unknown error"
                )
            }
        }
    }

    fun searchCity(city: String) {
        getCurrentWeather(city)
    }

    fun saveFavorite(city: String) {
        viewModelScope.launch {
            repository.insertFavorite(
                FavoriteCity(city = city)
            )
        }
    }
    fun deleteFavorite(city: FavoriteCity) {
        viewModelScope.launch {
            repository.deleteFavorite(city)
        }
    }

}