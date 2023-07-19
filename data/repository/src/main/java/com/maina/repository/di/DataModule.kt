package com.maina.repository.di

import com.maina.domain.repository.AppRepository
import com.maina.network.di.provideRemoteSource
import com.maina.network.di.provideRetrofit
import com.maina.repository.datasources.AppRepositoryImpl
import org.koin.dsl.module

val DataModule = module {
    single { provideRetrofit() }
    factory { provideRemoteSource(retrofit = get()) }
    factory<AppRepository> { AppRepositoryImpl(remoteSource = get()) }
}