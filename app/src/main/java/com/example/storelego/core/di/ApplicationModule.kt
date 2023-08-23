package com.example.storelego.core.di

import android.content.Context
import com.example.storelego.AndroidApplication
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://us-central1-api-back-admission-test.cloudfunctions.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}