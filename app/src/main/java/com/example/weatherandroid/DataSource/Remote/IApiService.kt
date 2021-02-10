package com.example.weatherandroid.DataSource.Remote

import com.example.weatherandroid.Model.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IApiService {

    companion object{
        fun getNewsApiService()
                = RetrofitHelper.retrofitInstance.create(IApiService::class.java)
    }
    @GET(PATH_TOP_HEADLINES)
    fun getTopHeadlines(@Query(QUERY_PARAM_COUNTRY) country : String, @Header("Authorization") key : String)
            : Observable<WeatherResponse>

    @GET(PATH_HEADLINES_BY_CATEGORY)
    fun getTopHeadlinesByCategory(@Query(QUERY_PARAM_COUNTRY) country : String, @Query("category") category : String, @Header("Authorization") key : String)
            : Observable<WeatherResponse>

}