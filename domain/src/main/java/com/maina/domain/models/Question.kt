package com.maina.domain.models

data class Question(
    val id: Int,
    val choices: List<Choice>,
    val question: String,
)