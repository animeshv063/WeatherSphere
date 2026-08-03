package com.example.weathersphere.ui.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weathersphere.data.local.FavoriteCity

@Composable
fun FavoritesScreen(
    favorites: List<FavoriteCity>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(favorites) { city ->
            Text(text = city.city)
        }
    }
}