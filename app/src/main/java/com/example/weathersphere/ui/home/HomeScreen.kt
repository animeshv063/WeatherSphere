package com.example.weathersphere.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weathersphere.viewmodel.WeatherUiState

@Composable
fun HomeScreen(
    uiState: WeatherUiState
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator()
        }

        if (uiState.error != null) {
            Text(text = uiState.error)
        }

        if (uiState.weather != null) {
            Text(text = uiState.weather.location.name)
            Text(text = uiState.weather.location.region)
            Text(text = uiState.weather.location.country)
            Text(text = "${uiState.weather.current.temp_c}°C")
            Text(text = "Humidity: ${uiState.weather.current.humidity}%")
        }
    }
}