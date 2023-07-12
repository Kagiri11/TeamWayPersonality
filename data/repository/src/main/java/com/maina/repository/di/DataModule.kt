package com.maina.repository.di

import androidx.room.Room
import com.maina.local.Database
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DataModule = module {
    single {
        Room.databaseBuilder(androidContext(), Database::class.java, "app-db").build()
    }
}