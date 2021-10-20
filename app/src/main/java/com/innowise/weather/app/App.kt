package com.innowise.weather.app

import android.app.Application
import android.location.LocationManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, )
        ServiceLocator.register(locationManager)
    }
}