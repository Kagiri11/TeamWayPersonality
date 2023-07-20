package com.maina.repository.datasources

import android.util.Log
import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.domain.repository.AppRepository
import com.maina.domain.utils.Result
import com.maina.network.api.PersonalityRemoteSource
import com.maina.repository.mappers.toDomain

class AppRepositoryImpl(private val remoteSource: PersonalityRemoteSource) : AppRepository {

    override suspend fun getQuestions(): Result<List<Question>> {
        return safeApiCall { remoteSource.fetchQuestions().map { it.toDomain() } }
    }

    override suspend fun submitAnswer(questionId: Int, answer: String): Result<Unit> {
        return safeApiCall { remoteSource.submitAnswer(questionId, answer) }
    }

    override suspend fun completeTest(): Result<Trait> {
        return safeApiCall { remoteSource.fetchTraits().map { it.toDomain() }.random() }
    }

    private suspend fun <T : Any> safeApiCall(
        apiCall: suspend () -> T
    ) =
        try {
            Result.Success(data = apiCall.invoke())
        } catch (e: Exception) {
            Result.Error(errorDetails = e.message.toString())
        }
}