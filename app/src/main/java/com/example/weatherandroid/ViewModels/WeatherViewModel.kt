package com.example.weatherandroid.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherandroid.DataSource.Remote.API_KEY
import com.example.weatherandroid.DataSource.Remote.IApiService
import com.example.weatherandroid.Model.WeatherApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {

    private val weatherListMutableLiveData = MutableLiveData<WeatherApiResponse>()
    val weatherListLiveData: LiveData<WeatherApiResponse>
        get() = weatherListMutableLiveData

    fun init() {
        IApiService
            .getWeatherApiService()
            .getWeather("Miami", API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { result -> weatherListMutableLiveData.postValue(result) }
            .subscribe()
    }
}