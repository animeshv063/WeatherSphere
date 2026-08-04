package com.example.weathersphere.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersphere.data.model.Hour

@Composable
fun HourlyForecast(
    hours: List<Hour>
) {
    LazyRow {
        items(hours) {
            hour ->
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = hour.time)
                    Text(text = "${hour.temp_c}°C")
                    Text(text = hour.condition.text)
                }
        }
    }
}