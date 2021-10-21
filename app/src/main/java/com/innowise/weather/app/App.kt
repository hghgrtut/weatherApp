package com.innowise.weather.app

import android.app.Application
import android.location.LocationManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.register(applicationContext)
        ServiceLocator.register(getSystemService(LOCATION_SERVICE) as LocationManager)
    }
}