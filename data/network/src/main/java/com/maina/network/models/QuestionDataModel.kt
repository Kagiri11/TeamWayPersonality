package com.maina.network.models

data class QuestionDataModel(
    val choiceDataModels: List<ChoiceDataModel>,
    val id: String
)