package com.maina.network.api

import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel
import retrofit2.http.GET

interface PersonalityRemoteSource {

    @GET("questions")
    suspend fun fetchQuestions(): List<QuestionDataModel>

    @GET("traits")
    suspend fun fetchTraits(): List<TraitDataModel>



}