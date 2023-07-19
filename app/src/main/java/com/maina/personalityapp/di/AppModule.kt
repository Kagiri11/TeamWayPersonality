package com.maina.personalityapp.di

import com.maina.personalityapp.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { MainViewModel(appRepository = get()) }
}