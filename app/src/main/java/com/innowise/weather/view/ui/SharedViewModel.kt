package com.innowise.weather.view.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innowise.weather.presenter.Repository
import io.reactivex.rxjava3.disposables.Disposable

class SharedViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().also { loadForecast() }

    val text: LiveData<String> = _text

    private fun loadForecast(): Disposable =
        Repository().getForecast().subscribe { t -> _text.postValue(t.toString()) }
}