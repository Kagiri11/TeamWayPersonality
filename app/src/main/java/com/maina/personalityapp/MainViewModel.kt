package com.maina.personalityapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maina.domain.models.Question
import com.maina.domain.repository.AppRepository
import com.maina.domain.utils.Result
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    private val _questionnaireProgress = MutableLiveData<Float>()
    val questionnaireProgress: LiveData<Float> get() = _questionnaireProgress

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get()= _isLoading

    private val questions = mutableListOf<Question>()

    var currentQuestionIndex = 0


    init {
        fetchQuestions()
    }

    fun fetchQuestions() {
        viewModelScope.launch {
            when(val result = appRepository.getQuestions()){
                is Result.Success -> {
                    questions.addAll(result.data)
                    _currentQuestion.value = questions.first()
                    calculateProgress()
                }
                is Result.Error -> {}
            }

            Log.d("PersonalityApp", "Questions here $questions")
        }
    }

    private fun calculateProgress(){
        when{
            questions.size == 1 -> {
                Log.d("PersonalityApp", "Progress in vm in one ${_questionnaireProgress.value}")
                _questionnaireProgress.value = 1F
            }
            questions.size >1 -> {
                _questionnaireProgress.value = ((currentQuestionIndex).toDouble()/questions.size).toFloat()
                Log.d("PersonalityApp", "Progress in vm in greater ${_questionnaireProgress.value}")
            }
        }
    }

    fun moveToNextQuestion(){
        currentQuestionIndex += 1
        _currentQuestion.value = questions[currentQuestionIndex]
        calculateProgress()
    }


    fun moveToPreviousQuestion(){
        currentQuestionIndex -= 1
        _currentQuestion.value = questions[currentQuestionIndex]
        calculateProgress()
    }

    fun answerQuestion(questionId: Int,answer: String) = viewModelScope.launch {
        Log.d("PersonalityApp","Answering with .. $answer")
        appRepository.submitAnswer(questionId, answer)
    }

}