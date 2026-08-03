package com.example.weathersphere.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun BottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar {

        NavigationBarItem(
            selected  = selectedIndex == 0,
            onClick = {
                onItemSelected(0)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            }
        )
        NavigationBarItem(
            selected = selectedIndex  == 1,
            onClick = {
                onItemSelected(1)
            },

            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        )
        NavigationBarItem(
            selected  = selectedIndex == 2,
            onClick = {
                onItemSelected(2)
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Favorites"
                )
            }
        )
    }
}