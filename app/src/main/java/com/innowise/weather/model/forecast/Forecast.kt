package com.innowise.weather.model.forecast

import com.innowise.weather.model.forecast.concreteforecast.ConcreteForecast
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "list") var forecastList: List<ConcreteForecast>,
    @Json(name = "city") val city: City
) {
    fun getCity(): String = city.name
}