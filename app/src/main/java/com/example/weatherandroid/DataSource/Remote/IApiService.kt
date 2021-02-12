package com.example.weatherandroid.DataSource.Remote

import com.example.weatherandroid.Model.WeatherApiResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IApiService {

    companion object{
        fun getWeatherApiService()
                = RetrofitHelper.retrofitInstance.create(IApiService::class.java)
    }
    @GET(PATH_WEATHER)
    fun getWeather(@Query(QUERY_PARAM_CITY) city : String, @Query(QUERY_PARAM_API_KEY) key : String)
            : Observable<WeatherApiResponse>


}