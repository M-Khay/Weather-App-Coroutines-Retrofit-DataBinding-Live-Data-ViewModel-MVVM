package com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.network

import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.Details
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService{
    @GET("weather")
   suspend fun getWeatherForCity(@Query("q") q: String,@Query("appid") appid:String): Details
}