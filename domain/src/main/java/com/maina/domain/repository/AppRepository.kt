package com.maina.domain.repository

import com.maina.domain.models.Question
import com.maina.domain.models.Trait

interface AppRepository {

    suspend fun getQuestion(questionNumber: Int): Result<Question>

    suspend fun submitAnswer(answer: String): Result<Trait>

}