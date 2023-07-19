package com.maina.domain.repository

import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.domain.utils.Result

interface AppRepository {

    suspend fun getQuestions(): Result<List<Question>>

    suspend fun submitAnswer(questionId: Int,answer: String): Result<Unit>

    suspend fun completeTest(): Result<Trait>

}