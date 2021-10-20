package com.innowise.weather.presenter

import com.innowise.weather.model.Forecast
import com.innowise.weather.presenter.api.ApiImplementation
import io.reactivex.rxjava3.core.Single

class Repository {
    fun getForecast(): Single<Forecast> = ApiImplementation.getForecast(52.425163, 31.015039)
}