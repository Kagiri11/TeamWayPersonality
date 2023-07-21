package com.maina.personalityapp

import android.app.Application
import com.maina.personalityapp.di.AppModule
import com.maina.repository.di.DataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PersonalityApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = listOf(DataModule, AppModule)
        startKoin {
            androidContext(this@PersonalityApplication)
            modules(modules)
        }
    }
}