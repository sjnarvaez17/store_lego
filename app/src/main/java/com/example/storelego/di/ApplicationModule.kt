package com.example.storelego.di

import android.content.Context
import com.example.storelego.AndroidApplication
import com.example.storelego.data.repository.ProductRepositoryImpl
import com.example.storelego.data.source.ProductRemoteDataSource
import com.example.storelego.data.source.ProductApi
import com.example.storelego.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun providesDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @Singleton
    fun providesProductApi(): ProductApi = NetworkModule.getApiService()

    @Provides
    @Singleton
    fun providesRemoteDataSource(productApi: ProductApi) =
        ProductRemoteDataSource(productApi)

    @Provides
    @Singleton
    fun providesRepository(productRemoteDataSource: ProductRemoteDataSource): ProductRepository =
        ProductRepositoryImpl(productRemoteDataSource)
}
