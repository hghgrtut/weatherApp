package com.innowise.weather.model.forecast

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class City(@Json(name = "name") val name: String)
