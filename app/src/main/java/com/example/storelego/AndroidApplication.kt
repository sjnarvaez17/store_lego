package com.example.storelego

import android.app.Application
import com.example.storelego.di.ApplicationComponent
import com.example.storelego.di.DaggerApplicationComponent

class AndroidApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}