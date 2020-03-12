package com.yourself.weatherappcoroutinesaacretrofitmvvm.data.weather

import com.google.gson.annotations.SerializedName

data class Details(val id : Long, val name :String, @SerializedName("cod") val code  : Int, val main : Main)

