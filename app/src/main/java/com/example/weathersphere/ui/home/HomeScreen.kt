package com.example.weathersphere.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersphere.ui.components.WeatherCard
import com.example.weathersphere.viewmodel.WeatherUiState

@Composable
fun HomeScreen(
    uiState: WeatherUiState,
    onSearch: (String) -> Unit,
    onTyping: (String) -> Unit,
    onAddFavorite: (String) -> Unit
) {

    var city by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = city,
            onValueChange = {
                city = it
                onTyping(it)
            },
            label = {
                Text("Enter City")
            },
            modifier = Modifier.fillMaxWidth()
        )

        if (uiState.suggestions.isNotEmpty()) {

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                uiState.suggestions.forEach { suggestion ->

                    ListItem(

                        headlineContent = {
                            Text(suggestion.name)
                        },

                        supportingContent = {
                            Text("${suggestion.region}, ${suggestion.country}")
                        },

                        modifier = Modifier.clickable {

                            city = suggestion.name

                            onSearch(suggestion.name)

                        }

                    )

                }

            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (city.isNotBlank())
                    onSearch(city)
            }
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(20.dp))

        when {

            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            uiState.error != null -> {
                Text(uiState.error!!)
            }

            uiState.weather != null -> {

                val weather = uiState.weather

                Text(
                    weather.location.name,
                    style = MaterialTheme.typography.headlineLarge
                )

                Text(weather.current.condition.text)

                Spacer(modifier = Modifier.height(12.dp))

                WeatherIcon(weather.current.condition.icon)

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "${weather.current.temp_c}°C",
                    style = MaterialTheme.typography.displayMedium
                )

                Spacer(modifier = Modifier.height(20.dp))

                WeatherCard(
                    "Feels Like",
                    "${weather.current.feelslike_c}°C"
                )

                WeatherCard(
                    "Humidity",
                    "${weather.current.humidity}%"
                )

                WeatherCard(
                    "Wind",
                    "${weather.current.wind_kph} km/h"
                )

                WeatherCard(
                    "Pressure",
                    "${weather.current.pressure_mb} mb"
                )

                WeatherCard(
                    "UV",
                    weather.current.uv.toString()
                )

                Spacer(modifier = Modifier.height(20.dp))

                FilledTonalButton(
                    onClick = {
                        onAddFavorite(weather.location.name)
                    }
                ) {

                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text("Add To Favorites")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "Hourly Forecast",
                    style = MaterialTheme.typography.titleLarge
                )

                HourlyForecast(
                    uiState.hourlyForecast
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    "7 Day Forecast",
                    style = MaterialTheme.typography.titleLarge
                )

                WeeklyForecast(
                    uiState.weeklyForecast
                )

            }

            else -> {

                Text(
                    "Search a city to view weather"
                )

            }

        }

    }

}