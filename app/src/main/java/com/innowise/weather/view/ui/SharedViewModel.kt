package com.innowise.weather.view.ui

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.innowise.weather.FORECAST
import com.innowise.weather.app.ServiceLocator
import com.innowise.weather.model.forecast.Forecast
import com.innowise.weather.presenter.Repository

class SharedViewModel : ViewModel() {
    private val _forecast = MutableLiveData<Forecast>()

    val forecast: LiveData<Forecast> = _forecast

    fun loadForecast() {
        Repository().getForecast()
            .onErrorReturn {
                val json = ServiceLocator.get(SharedPreferences::class).getString(FORECAST, null)
                Gson().fromJson(json, Forecast::class.java)
            }
            .subscribe { value -> _forecast.postValue(value) }
    }
}