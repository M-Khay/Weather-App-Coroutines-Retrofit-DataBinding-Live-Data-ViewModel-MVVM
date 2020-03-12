package com.yourself.weatherappcoroutinesaacretrofitmvvm.repository

import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.network.WeatherApiService
import com.yourself.weatherappcoroutinesaacretrofitmvvm.util.API_KEY

class WeatherRepositoryImpl (private val weatherApiService: WeatherApiService) :
    WeatherRepository {

    override suspend fun getWeatherForCity(cityName: String)= weatherApiService.getWeatherForCity(cityName,
        API_KEY)
}