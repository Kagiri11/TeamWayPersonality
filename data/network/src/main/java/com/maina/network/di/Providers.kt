package com.maina.network.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit() : Retrofit {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    return Retrofit.Builder()
        .baseUrl("http://demo7764327.mockable.io/personalize/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}