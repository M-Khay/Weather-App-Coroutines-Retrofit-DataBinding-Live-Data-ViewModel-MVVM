package com.yourself.weatherappcoroutinesaacretrofitmvvm.di

import com.yourself.weatherappcoroutinesaacretrofitmvvm.ui.WeatherViewModel
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


// Definition of the Application graph
//Because you might want to use DictionaryRepositoryModule in other features of the app and
// might not want to create a new object every time you need it, you can designate it as a unique
// instance for the whole app.

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class, AppModule::class,
        NetworkModule::class, WeatherRepositoryModule::class
    )
)

interface AppComponent {

    fun inject(weatherViewModel: WeatherViewModel)
}


