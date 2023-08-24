package com.example.storelego.core.di

import com.example.storelego.AndroidApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
}
