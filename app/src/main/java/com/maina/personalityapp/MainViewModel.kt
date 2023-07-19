package com.maina.personalityapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maina.domain.models.Question
import com.maina.domain.repository.AppRepository
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    private val _questionnaireProgress = MutableLiveData<Float>(0F)
    val questionnaireProgress: LiveData<Float> get() = _questionnaireProgress

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get()= _isLoading


    init {
        fetchQuestions()
    }

    fun fetchQuestions() {
        viewModelScope.launch {
            val questions = appRepository.getQuestions()

            Log.d("PersonalityApp", "Questions here $questions")
        }
    }

    fun answerQuestion(questionId: Int,answer: String) = viewModelScope.launch {
        appRepository.submitAnswer(questionId, answer)
    }

}