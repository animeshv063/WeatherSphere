package com.example.weathersphere.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.weathersphere.navigation.NavGraph
import com.example.weathersphere.ui.components.BottomBar

@Composable
fun AppScaffold() {

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                }
            )
        }
    ) { _ ->

        NavGraph(
            selectedIndex = selectedIndex
        )
    }
}