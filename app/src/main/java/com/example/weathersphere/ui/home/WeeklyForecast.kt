package com.example.weathersphere.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersphere.data.model.WeekDay

@Composable
fun WeeklyForecast(
    forecast : List<WeekDay>
) {
    LazyColumn {
        items(forecast) {
            day -> Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = day.date)
                Text(text = "Max Temp: ${day.day.maxtemp_c}°C")
                Text(text = "Min Temp: ${day.day.mintemp_c}°C")
                Text(text = day.day.condition.text)
            }
        }
    }
}