package com.maina.repository.datasources

import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.domain.repository.AppRepository
import com.maina.network.api.PersonalityRemoteSource

class AppRepositoryImpl(private val remoteSource: PersonalityRemoteSource): AppRepository {

    override suspend fun getQuestion(questionNumber: Int): Result<Question> {
        TODO("Not yet implemented")
    }

    override suspend fun submitAnswer(answer: String): Result<Trait> {
        TODO("Not yet implemented")
    }
}