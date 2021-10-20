package com.innowise.weather.model

import com.innowise.weather.model.concreteforecast.ConcreteForecast
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Forecast(
    @Json(name = "list") val weatherList: List<ConcreteForecast>,
    @Json(name = "city") val city: City
)