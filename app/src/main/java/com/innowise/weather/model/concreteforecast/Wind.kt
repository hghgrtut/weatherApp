package com.innowise.weather.model.concreteforecast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed") val speed: Double,
    @Json(name = "deg") val direction: Int,
    @Json(name = "gust") val gust: Double
)