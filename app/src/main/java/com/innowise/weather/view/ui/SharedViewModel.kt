package com.innowise.weather.view.ui

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.innowise.weather.FORECAST
import com.innowise.weather.R
import com.innowise.weather.app.ServiceLocator
import com.innowise.weather.model.forecast.Forecast
import com.innowise.weather.presenter.Repository
import java.net.UnknownHostException

class SharedViewModel : ViewModel() {
    private val _forecast = MutableLiveData<Forecast>()

    val forecast: LiveData<Forecast> = _forecast

    private val _error = MutableLiveData<Int>()
    val error: LiveData<Int> = _error

    fun loadForecast() {
        Repository().getForecast()
            .onErrorReturn {
                val json = ServiceLocator.get(SharedPreferences::class).getString(FORECAST, null)
                json ?: throw UnknownHostException()
                Gson().fromJson(json, Forecast::class.java)
            }
            .subscribe ({ value -> _forecast.postValue(value) },
                { _error.postValue(R.string.error_no_internet) })
    }
}