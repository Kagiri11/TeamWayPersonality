package com.maina.network.api

import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonalityRemoteSource {

    @GET("questions")
    suspend fun fetchQuestions(): List<QuestionDataModel>

    @POST("answer")
    suspend fun submitAnswer(questionId: Int, answer: String)

    @GET("traits")
    suspend fun fetchTraits(): List<TraitDataModel>



}