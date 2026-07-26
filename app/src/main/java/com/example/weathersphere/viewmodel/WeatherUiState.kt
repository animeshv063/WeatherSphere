package com.example.weathersphere.viewmodel

import com.example.weathersphere.data.model.WeatherResponse

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weather: WeatherResponse? = null,
    val error: String? = null
)