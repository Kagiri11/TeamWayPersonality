package com.maina.network.api

import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonalityRemoteSource {

    @GET("questions")
    suspend fun fetchQuestions(): Response<List<QuestionDataModel>>

    @POST("answer")
    suspend fun submitAnswer(questionId: Int, answer: String): Response<Unit>

    @GET("traits")
    suspend fun fetchTraits(): Response<List<TraitDataModel>>



}