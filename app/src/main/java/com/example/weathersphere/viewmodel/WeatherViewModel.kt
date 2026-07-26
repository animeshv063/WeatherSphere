package com.example.weathersphere.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathersphere.data.model.WeatherResponse
import com.example.weathersphere.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel(){

    private val repository = WeatherRepository()

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
}