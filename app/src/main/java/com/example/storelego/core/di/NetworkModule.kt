package com.example.storelego.core.di

import com.example.storelego.data.source.ProductApi
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private var productApi: ProductApi? = null

    fun getApiService(): ProductApi {
        productApi?.let { return it }

        val retrofit = Retrofit.Builder()
            .baseUrl(ProductApi.BASE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(createConverterFactory())
            .build()

        return retrofit.create(ProductApi::class.java).also { productApi = it }
    }

    private fun createConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}