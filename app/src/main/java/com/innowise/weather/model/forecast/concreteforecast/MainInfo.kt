package com.innowise.weather.model.forecast.concreteforecast

import com.innowise.weather.HelperFuns
import com.innowise.weather.R
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.math.roundToInt

@JsonClass(generateAdapter = true)
data class MainInfo(
    @Json(name = "temp") val temperature: Double,
    @Json(name = "feels_like") val temperatureLike: Double,
    @Json(name = "grnd_level") val pressure: Int,
    @Json(name = "humidity") val humidity: Int
) {
    override fun toString(): String = HelperFuns.getString(R.string.string_main_info,
            temperature.roundToInt(),
            temperatureLike.roundToInt(),
            pressure,
            humidity
        )
}