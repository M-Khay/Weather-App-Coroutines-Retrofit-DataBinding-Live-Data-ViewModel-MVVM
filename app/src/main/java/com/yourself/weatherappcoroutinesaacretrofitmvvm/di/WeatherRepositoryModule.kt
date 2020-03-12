package com.yourself.weatherappcoroutinesaacretrofitmvvm.di

import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.WeatherRepository
import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.network.WeatherApiService
import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class WeatherRepositoryModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(weatherApiService: WeatherApiService):
            WeatherRepository = WeatherRepositoryImpl(weatherApiService)
}