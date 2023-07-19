package com.maina.repository.datasources

import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.domain.repository.AppRepository
import com.maina.network.api.PersonalityRemoteSource

class AppRepositoryImpl(private val remoteSource: PersonalityRemoteSource): AppRepository {
    override suspend fun getQuestions(): Result<List<Question>> {
        TODO("Not yet implemented")
    }

    override suspend fun submitAnswer(questionId: Int, answer: String): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun completeTest(): Result<Trait> {
        TODO("Not yet implemented")
    }
}