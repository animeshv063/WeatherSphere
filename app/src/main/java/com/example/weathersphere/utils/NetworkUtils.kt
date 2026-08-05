package com.example.weathersphere.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(
        ConnectivityManager::class.java
    )
    val network = connectivityManager.activeNetwork ?: return false

    val capabilities = connectivityManager.getNetworkCapabilities(network)

    return capabilities?.hasCapability(
        NetworkCapabilities.NET_CAPABILITY_INTERNET
    ) == true
}