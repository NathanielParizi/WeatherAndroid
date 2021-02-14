package com.example.weatherandroid.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherApiResponse(

    val city: City,
    val cnt: Int,
    val cod: String,
    val message: Int,
    val list: List<Forecast>
) : Parcelable

