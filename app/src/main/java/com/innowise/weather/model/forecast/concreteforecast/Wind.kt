package com.innowise.weather.model.forecast.concreteforecast

import com.innowise.weather.HelperFuns
import com.innowise.weather.R
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.math.roundToInt

@JsonClass(generateAdapter = true)
data class Wind(
    @Json(name = "speed") val speed: Double,
    @Json(name = "gust") val gust: Double
) {
    override fun toString() =
        HelperFuns.getString(R.string.string_wind, speed.roundToInt(), gust.roundToInt())
}