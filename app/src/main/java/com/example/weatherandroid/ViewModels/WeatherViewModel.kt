package com.example.weatherandroid.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherandroid.DataSource.Remote.API_KEY
import com.example.weatherandroid.DataSource.Remote.WeatherRepository
import com.example.weatherandroid.Model.WeatherApiResponse
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response


class WeatherViewModel : ViewModel(), KoinComponent {

    protected val service: WeatherRepository by inject()

    val loading2 = MutableLiveData<Boolean>()
    val loadingError2 = MutableLiveData<String?>()
    var job2: Job? = null
    val exceptionHandler2 = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception: ${throwable.localizedMessage}")
    }


    private val weatherListMutableLiveData = MutableLiveData<WeatherApiResponse>()
    val weatherListLiveData: LiveData<WeatherApiResponse>
        get() = weatherListMutableLiveData


    fun onError(message: String) {
//        loadingError2.value = message
//        loading2.value = false
//        Log.d("TAG", "onError: $message")
    }

    fun basicCoroutineFetch() {

        job2 = CoroutineScope(Dispatchers.IO + exceptionHandler2).launch {
            val response: Response<WeatherApiResponse> =
                service.getWeather(
                    "Miami", API_KEY
                )
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    weatherListMutableLiveData.postValue(response.body())
                    Log.d("GOLD", "fetchNews: ${weatherListMutableLiveData.value} ")
                    loadingError2.value = null
                    loading2.value = false
                } else {
                    onError("Error ${response.message()}")
                }
            }
        }

    }
}