package com.yourself.weatherappcoroutinesaacretrofitmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yourself.weatherappcoroutinesaacretrofitmvvm.R
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.DefaultState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.ErrorState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.LoadingState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather.WeatherState
import com.yourself.weatherappcoroutinesaacretrofitmvvm.databinding.WeatherFragmentBinding
import com.yourself.weatherappcoroutinesaacretrofitmvvm.di.ComponentInjector

class WeatherFragment : Fragment() {
    private lateinit var viewModel: WeatherViewModel

    companion object {
        val TAG = WeatherFragment::class.java.name
        fun newInstance() = WeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  binding : WeatherFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.weather_fragment,container,false)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java).also {
            ComponentInjector.component.inject(it)
        }
        binding.lifecycleOwner = this
        binding.weatherDetails = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWeatherForCity("London")
        viewModel.stateLiveData.observe(this.viewLifecycleOwner, weatherStateObeserver)
    }

    private val weatherStateObeserver = Observer<WeatherState> { state ->
        state?.let {
            when (state) {
                is DefaultState -> {

                }
                is LoadingState -> {

                }
                is ErrorState -> {

                }
            }
        }

    }
}