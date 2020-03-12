package com.yourself.weatherappcoroutinesaacretrofitmvvm.ui

import android.util.Log
import androidx.lifecycle.*
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.DefaultState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.ErrorState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.WeatherState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherViewModel : ViewModel() {

    @Inject
    lateinit var repository: WeatherRepository

    val TAG: String = WeatherViewModel::class.java.name
    var stateLiveData = MutableLiveData<WeatherState>()

    init {
        stateLiveData.value = DefaultState(null, true)
    }

    fun getWeatherForCity(cityName: String) {
// These are the following 2 ways to call repository and get result in the livedata
//        stateLiveData.value = liveData(Dispatchers.IO) {
//            val res = repository.getWeatherForCity("London")
//            val updatedState = DefaultState(res, true)
//            emit(updatedState)
//        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.getWeatherForCity(cityName)
                withContext(Dispatchers.Main) {
                    stateLiveData.value = DefaultState(result, true)

                }
            } catch (exception: Exception) {
                Log.d(TAG, "Error from API ${exception.localizedMessage}")
                withContext(Dispatchers.Main) {
                    stateLiveData.value = ErrorState(null, true)
                }
            }
        }
    }

}