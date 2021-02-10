package com.example.weatherandroid.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherandroid.DataSource.Remote.API_KEY
import com.example.weatherandroid.DataSource.Remote.IApiService
import com.example.weatherandroid.Model.WeatherResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherViewModel : ViewModel() {

    private val newsListMutableLiveData = MutableLiveData<WeatherResponse>()
    val newsListLiveData: LiveData<WeatherResponse>
        get() = newsListMutableLiveData

    init {
        IApiService
            .getNewsApiService()
            .getTopHeadlines("us", API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map { result -> newsListMutableLiveData.postValue(result) }
            .subscribe()
    }
}