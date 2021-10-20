package com.innowise.weather.presenter

import android.location.Location
import com.innowise.weather.app.ServiceLocator
import com.innowise.weather.model.Forecast
import com.innowise.weather.presenter.api.ApiImplementation
import io.reactivex.rxjava3.core.Single

class Repository {
    fun getForecast(): Single<Forecast> {
        val location: Location = ServiceLocator.locate()
        return ApiImplementation.getForecast(location.latitude, location.longitude)
    }
}