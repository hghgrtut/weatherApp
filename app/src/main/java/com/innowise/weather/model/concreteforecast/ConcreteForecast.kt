package com.innowise.weather.model.concreteforecast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ConcreteForecast(
    @Json(name = "main") val main: MainInfo,
    @Json(name = "weather") val weather: List<Weather>,
    @Json(name = "wind") val wind: Wind,
    @Json(name = "pop") val rainProbability: Double
)