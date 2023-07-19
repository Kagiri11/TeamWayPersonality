package com.maina.repository.di

import com.maina.network.di.provideRetrofit
import org.koin.dsl.module

val DataModule = module {
   single { provideRetrofit() }
}