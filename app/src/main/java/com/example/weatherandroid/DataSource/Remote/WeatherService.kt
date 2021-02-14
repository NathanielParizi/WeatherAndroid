package com.example.weatherandroid.DataSource.Remote

import com.example.weatherandroid.Model.WeatherApiResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Response
import retrofit2.Retrofit

class WeatherService : KoinComponent {

    private val retrofitBuilder: Retrofit.Builder by inject()
    private var apiService: IApiService = retrofitBuilder.baseUrl(WEATHER_API_BASE_URL)
        .build().create(IApiService::class.java)

    suspend fun getWeather(city: String, key: String): Response<WeatherApiResponse> {
        return apiService.getWeather(city, key)
    }
}