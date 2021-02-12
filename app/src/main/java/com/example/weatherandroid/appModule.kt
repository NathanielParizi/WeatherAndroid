package com.example.weatherandroid

import com.example.weatherandroid.ViewModels.WeatherViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.text.DateFormat
import java.util.concurrent.TimeUnit
import javax.crypto.Cipher

val appModule = module {

    viewModel { WeatherViewModel() }


    single {
        val gson: Gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setDateFormat(DateFormat.LONG)
            .create()
        GsonConverterFactory.create(gson)
    } bind GsonConverterFactory::class

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        val client = OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .apply { HttpLoggingInterceptor.Level.BODY }
            .cache(null)
            .addInterceptor(loggingInterceptor)
        client.build()


    }

    single {
        val builder =
            Retrofit.Builder()
                .addConverterFactory(get<GsonConverterFactory>())
                .client(get())

        builder
    }



}