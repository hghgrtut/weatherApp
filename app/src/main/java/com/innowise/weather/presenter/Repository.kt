package com.innowise.weather.presenter

import android.content.SharedPreferences
import android.location.Location
import com.google.gson.Gson
import com.innowise.weather.FORECAST
import com.innowise.weather.app.ServiceLocator
import com.innowise.weather.model.forecast.Forecast
import com.innowise.weather.presenter.api.ApiImplementation
import io.reactivex.rxjava3.core.Single

class Repository {
    fun getForecast(): Single<Forecast> {
        val location: Location = ServiceLocator.locate()
        return ApiImplementation.getForecast(location.latitude, location.longitude).doAfterSuccess {
            val sharedPreferences: SharedPreferences = ServiceLocator.locate()
            sharedPreferences.edit().putString(FORECAST, Gson().toJson(it)).apply()
        }
    }
}