package com.example.weathersphere.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersphere.data.model.WeekDay

@Composable
fun WeeklyForecast(
    forecast: List<WeekDay>
) {

    LazyColumn {

        items(forecast) { day ->

            Card(
                modifier = Modifier.padding(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(12.dp)
                ) {

                    Text(day.date)

                    Text("Max : ${day.day.maxtemp_c}°C")

                    Text("Min : ${day.day.mintemp_c}°C")

                    Text(day.day.condition.text)
                }
            }
        }
    }
}