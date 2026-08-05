package com.example.weathersphere.ui.theme

import androidx.compose.ui.graphics.Color

fun getBackgroundColor(weather: String) = when (weather) {
    "Sunny" -> Color.Yellow
    "Rain" -> Color.Blue
    "Cloudy" -> Color.Gray
    else -> Color.White
}