package com.yourself.weatherappcoroutinesaacretrofitmvvm

import android.app.Application
import com.yourself.weatherappcoroutinesaacretrofitmvvm.di.ComponentInjector


// appComponent lives in the Application class to share its lifecycle
class MyApplication : Application()  {

    override fun onCreate() {
        super.onCreate()

        ComponentInjector.init()


    }
}