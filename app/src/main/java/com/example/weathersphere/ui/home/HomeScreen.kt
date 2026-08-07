package com.example.weathersphere.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersphere.viewmodel.WeatherUiState

@Composable
fun HomeScreen(
    uiState: WeatherUiState,
    onSearch: (String) -> Unit
) {

    var city by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = city,
            onValueChange = {
                city = it
            },
            label = {
                Text("Enter City")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (city.isNotBlank()) {
                    onSearch(city)
                }
            }
        ) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(24.dp))

        when {

            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            uiState.error != null -> {
                Text(uiState.error)
            }

            uiState.weather != null -> {

                val weather = uiState.weather

                Text(
                    weather.location.name,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text("${weather.current.temp_c}°C")

                Text("Humidity : ${weather.current.humidity}%")
            }

            else -> {

                Text(
                    "Search a city to view weather",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}