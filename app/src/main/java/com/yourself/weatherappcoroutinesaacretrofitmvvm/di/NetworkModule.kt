package com.yourself.weatherappcoroutinesaacretrofitmvvm.di

import com.yourself.weatherappcoroutinesaacretrofitmvvm.repository.network.WeatherApiService
import com.yourself.weatherappcoroutinesaacretrofitmvvm.util.API_KEY
import com.yourself.weatherappcoroutinesaacretrofitmvvm.util.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    //However, the way to create an instance of DictionaryApi
    //is different from what you've been doing until now. It's not a class instantiation;
    // it's the result of calling Retrofit.Builder() a
    @Provides
    fun provideWeatherApiService(retrofit: Retrofit) = retrofit.create(WeatherApiService::class.java)

    //You can use the @Provides annotation in Dagger modules to tell Dagger how to provide classes
    //that your project doesn't own (e.g. an instance of Retrofit).
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun provideOkHttpClient():OkHttpClient{
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader("x-rapidapi-key", API_KEY).build()
                chain.proceed(request)
            }
            .build()
    }
}