package com.innowise.weather.model.concreteforecast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainInfo(
    @Json(name = "temp") val temperature: Double,
    @Json(name = "feels_like") val temperatureLike: Double,
    @Json(name = "grnd_level") val pressure: Int,
    @Json(name = "humidity") val humidity: Int
)