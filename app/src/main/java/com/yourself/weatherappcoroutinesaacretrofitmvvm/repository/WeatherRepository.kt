package com.yourself.weatherappcoroutinesaacretrofitmvvm.repository

import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.Details
import javax.inject.Inject

interface WeatherRepository {
 suspend fun getWeatherForCity(cityName: String): Details
}