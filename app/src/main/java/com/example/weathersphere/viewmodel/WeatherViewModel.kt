package com.example.weathersphere.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathersphere.data.local.AppDatabase
import com.example.weathersphere.data.local.FavoriteCity
import com.example.weathersphere.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = WeatherRepository(
        AppDatabase.getDatabase(
            getApplication()
        ).favoriteCityDao()
    )

    private val _uiState =
        MutableStateFlow(
            WeatherUiState()
        )

    val uiState: StateFlow<WeatherUiState>
            = _uiState

    fun searchCity(
        city: String
    ) {

        viewModelScope.launch {

            _uiState.value =
                _uiState.value.copy(
                    isLoading = true,
                    error = null
                )

            try {

                val weather =
                    repository.getCurrentWeather(city)

                val hourly =
                    repository.getHourlyForecast(city)

                val weekly =
                    repository.getWeeklyForecast(city)

                val favorites =
                    repository.getFavorites()

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        weather = weather,

                        hourlyForecast =
                            hourly.forecast.forecastday.first().hour,

                        weeklyForecast =
                            weekly.forecast.forecastday,

                        favorites = favorites
                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(

                        isLoading = false,

                        error = e.message
                    )
            }
        }
    }

    fun saveFavorite(
        city: String
    ) {

        viewModelScope.launch {

            repository.insertFavorite(
                FavoriteCity(
                    city = city
                )
            )

            _uiState.value =
                _uiState.value.copy(
                    favorites =
                        repository.getFavorites()
                )
        }
    }

    fun deleteFavorite(
        city: FavoriteCity
    ) {

        viewModelScope.launch {

            repository.deleteFavorite(city)

            _uiState.value =
                _uiState.value.copy(
                    favorites =
                        repository.getFavorites()
                )
        }
    }
    fun changeTemperatureUnit(
        isCelsius: Boolean
    ) {
        _uiState.value =
            _uiState.value.copy(
                isCelsius = isCelsius
            )
    }
}