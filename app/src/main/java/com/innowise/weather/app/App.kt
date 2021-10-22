package com.innowise.weather.app

import android.app.Application
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import com.innowise.weather.app.ServiceLocator.register

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        register(applicationContext)
        register(getSystemService(LOCATION_SERVICE) as LocationManager)
        register(applicationContext.getSharedPreferences("My_pref", AppCompatActivity.MODE_PRIVATE))
    }
}