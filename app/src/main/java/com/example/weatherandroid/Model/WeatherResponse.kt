package com.example.weatherandroid.Model

data class WeatherResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Main>,
    val message: Int
)