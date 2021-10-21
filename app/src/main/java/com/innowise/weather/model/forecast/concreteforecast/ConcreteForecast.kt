package com.innowise.weather.model.forecast.concreteforecast

import com.innowise.weather.HelperFuns
import com.innowise.weather.R
import com.innowise.weather.model.utils.pictureStringToRes
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.math.roundToInt

@JsonClass(generateAdapter = true)
data class ConcreteForecast(
    @Json(name = "main") val main: MainInfo,
    @Json(name = "weather") val weather: List<Weather>,
    @Json(name = "wind") val wind: Wind,
    @Json(name = "pop") val rainProbability: Double
) {
    fun getPictureRes(): Int = requireNotNull(pictureStringToRes[weather.first().icon])
    fun getOverview(): String = weather.joinToString(", ") { it.description }

    override fun toString(): String =
        "$main ${rainStr()} ${weather.joinToString(", ") { it.description } } $wind"

    private fun rainStr() = HelperFuns.getString(R.string.string_rain, rainProbability.roundToInt())
}