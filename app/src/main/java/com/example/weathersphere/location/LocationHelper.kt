package com.example.weathersphere.location

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationServices

class LocationHelper(
    private val context: Context
) {

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(
        onLocationReceived: (Double, Double) -> Unit
    ) {
        val client = LocationServices.getFusedLocationProviderClient(context)

        client.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                onLocationReceived(
                    location.latitude,
                    location.longitude
                )
            }
        }
    }
}