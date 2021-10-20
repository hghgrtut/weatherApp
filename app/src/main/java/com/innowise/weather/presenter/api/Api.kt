package com.innowise.weather.presenter.api

import com.innowise.weather.model.Forecast
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiImplementation {
    private val baseUrl = "http://api.openweathermap.org/data/2.5/"
    private val service = Retrofit.Builder()
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
        .create(ApiInterface::class.java)

    fun getForecast(latitude: Double, longitude: Double): Single<Forecast> =
        service.getForecast(latitude, longitude).map { it.body()!! }
}

interface ApiInterface {
    @GET("forecast")
    fun getForecast(
        @Query(value = "lat") latitude: Double,
        @Query(value = "lon") longitude: Double,
        @Query(value = "appid") key: String = "18da837ea3a2403adb97bd229286f8f7",
        @Query(value = "units") units: String = "metric",
        @Query(value = "units") lang: String = "ru",
    ): Single<Response<Forecast>>
}