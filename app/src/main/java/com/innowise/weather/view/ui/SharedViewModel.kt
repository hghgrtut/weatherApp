package com.innowise.weather.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innowise.weather.model.forecast.Forecast
import com.innowise.weather.presenter.Repository

class SharedViewModel : ViewModel() {
    private val _forecast = MutableLiveData<Forecast>()

    val forecast: LiveData<Forecast> = _forecast

    fun loadForecast() {
        Repository().getForecast().subscribe { value -> _forecast.postValue(value) }
    }
}