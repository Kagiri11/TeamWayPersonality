package com.maina.network.models

data class QuestionDataModel(
    val choices: List<ChoiceDataModel>,
    val id: String
)