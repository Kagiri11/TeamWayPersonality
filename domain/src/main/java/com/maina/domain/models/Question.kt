package com.maina.domain.models

data class Question(
    val choices: List<Choice>,
    val id: String
)