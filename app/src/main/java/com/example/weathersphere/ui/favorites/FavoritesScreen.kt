package com.example.weathersphere.ui.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weathersphere.data.local.FavoriteCity

@Composable
fun FavoritesScreen(
    favorites: List<FavoriteCity>,
    onDelete: (FavoriteCity) -> Unit
) {

    if (favorites.isEmpty()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )

            Text(
                "No Favourite Cities",
                style = MaterialTheme.typography.headlineSmall
            )

            Text(
                "Search a city and press ❤️ Add To Favorites"
            )
        }

        return
    }

    LazyColumn {

        items(favorites) { city ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),

                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        city.city,
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.titleMedium
                    )

                    IconButton(
                        onClick = {
                            onDelete(city)
                        }
                    ) {

                        Icon(
                            Icons.Default.Delete,
                            contentDescription = null
                        )

                    }

                }

            }

        }

    }

}