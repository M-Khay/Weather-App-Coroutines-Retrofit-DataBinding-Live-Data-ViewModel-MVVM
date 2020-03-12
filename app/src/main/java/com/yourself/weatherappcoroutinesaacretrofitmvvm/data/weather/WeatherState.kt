package com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather

sealed class WeatherState {
    abstract val data: Details?
    abstract val loadedAllItems: Boolean
}

data class DefaultState(override val data: Details?, override val loadedAllItems: Boolean) :
    WeatherState()

data class LoadingState(override val data: Details?, override val loadedAllItems: Boolean) :
    WeatherState()

data class ErrorState(override val data: Details?, override val loadedAllItems: Boolean) :
    WeatherState()
