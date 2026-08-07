package com.example.weathersphere.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors =
    lightColorScheme(

        primary = SkyBlue,

        secondary = DeepBlue,

        background = LightBlue,

        surface = White
    )

private val DarkColors =
    darkColorScheme()

@Composable
fun WeatherSphereTheme(
    darkTheme: Boolean =
        isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme =
            if (darkTheme)
                DarkColors
            else
                LightColors,

        typography = Typography,

        content = content
    )
}