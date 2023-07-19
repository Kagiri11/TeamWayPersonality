package com.maina.personalityapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maina.domain.repository.AppRepository
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository): ViewModel() {

    fun fetchQuestions(){
        viewModelScope.launch {
            val questions = appRepository.getQuestions()

            Log.d("PersonalityApp", "Questions here $questions")
        }
    }
}