package com.example.weatherandroid.Model

data class WeatherApiResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val message: Int,
    val list: List<Forecast>
)

