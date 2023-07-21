package com.maina.repository.datasources

import android.util.Log
import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.domain.repository.AppRepository
import com.maina.domain.utils.Result
import com.maina.network.api.PersonalityRemoteSource
import com.maina.repository.mappers.toDomain
import retrofit2.Response

class AppRepositoryImpl(private val remoteSource: PersonalityRemoteSource) : AppRepository {

    override suspend fun getQuestions(): Result<List<Question>> {
        return when (val networkCall = safeApiCall(apiCall = { remoteSource.fetchQuestions() })) {
            is Result.Success -> Result.Success(networkCall.data.map { it.toDomain() })
            is Result.Error -> Result.Error(networkCall.errorDetails)
        }
    }

    override suspend fun submitAnswer(questionId: Int, answer: String): Result<Unit> {
        return when (val networkCall = safeApiCall(apiCall = { remoteSource.submitAnswer(questionId, answer) })) {
            is Result.Success -> Result.Success(data = Unit)
            is Result.Error -> Result.Error(networkCall.errorDetails)
        }
    }

    override suspend fun completeTest(): Result<Trait> {
        return when (val networkCall = safeApiCall(apiCall = { remoteSource.fetchTraits() })) {
            is Result.Success -> Result.Success(data = networkCall.data.map { it.toDomain() }
                .random())

            is Result.Error -> Result.Error(networkCall.errorDetails)
        }
    }

    private suspend fun <T : Any> safeApiCall(
        apiCall: suspend () -> Response<T>
    ) =
        try {
            val call = apiCall.invoke()
            if (call.isSuccessful) {
                Result.Success(data = call.body()!!)
            } else {
                Result.Error(call.message())
            }
        } catch (e: Exception) {
            Result.Error(errorDetails = e.message.toString())
        }
}