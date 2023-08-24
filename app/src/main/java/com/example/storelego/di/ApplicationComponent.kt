package com.example.storelego.di

import com.example.storelego.AndroidApplication
import com.example.storelego.presentation.activity.ProductDetailActivity
import com.example.storelego.presentation.activity.ProductListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)

    fun inject(productListActivity: ProductListActivity)

    fun inject(productDetailActivity: ProductDetailActivity)
}
