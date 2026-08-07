package com.example.weathersphere.ui.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weathersphere.data.local.FavoriteCity

@Composable
fun FavoritesScreen(
    favorites: List<FavoriteCity>
) {

    if (favorites.isEmpty()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "No Favourite Cities",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        return
    }

    LazyColumn {

        items(favorites) {

            Text(it.city)
        }
    }
}