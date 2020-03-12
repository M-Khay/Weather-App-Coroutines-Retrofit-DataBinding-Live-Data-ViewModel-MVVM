package com.yourself.weatherappcoroutinesaacretrofitmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.yourself.weatherappcoroutinesaacretrofitmvvm.R
import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.WeatherRepositoryImpl

class MainActivity : AppCompatActivity() {

//    @Inject
//    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().add(
                R.id.root_layout,
                WeatherFragment.newInstance(),
                WeatherFragment.TAG
            ).commitNow()

//        val savedStateFactory = SavedStateViewModelFactory(application,this)
//        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

    }

}
