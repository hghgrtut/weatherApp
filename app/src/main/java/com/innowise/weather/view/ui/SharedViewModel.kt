package com.innowise.weather.view.ui

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innowise.weather.presenter.Repository

class SharedViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()

    val text: LiveData<String> = _text

    fun loadForecast() {
        Repository().getForecast().subscribe { t -> _text.postValue(t.toString()) }
    }
}