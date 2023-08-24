package com.example.storelego.core.di

import android.content.Context
import com.example.storelego.AndroidApplication
import com.example.storelego.data.source.ProductRemoteDataSource
import com.example.storelego.data.source.ProductApi
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi = NetworkModule.getApiService()

    @Provides
    @Singleton
    fun provideGetProductDataSource(productApi: ProductApi) = ProductRemoteDataSource(productApi)

}