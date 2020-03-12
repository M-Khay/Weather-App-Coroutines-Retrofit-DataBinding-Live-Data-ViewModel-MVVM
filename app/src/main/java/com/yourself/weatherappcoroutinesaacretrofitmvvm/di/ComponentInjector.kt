package com.yourself.weatherappcoroutinesaacretrofitmvvm.di

class ComponentInjector {

    companion object {
        lateinit var component: AppComponent
            fun init() {
                component = DaggerAppComponent.builder()
                    .weatherRepositoryModule(WeatherRepositoryModule())
                    .build()
            }

    }
}