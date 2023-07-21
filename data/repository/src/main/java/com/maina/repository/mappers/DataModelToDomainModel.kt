package com.maina.repository.mappers

import com.maina.domain.models.Choice
import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.network.models.ChoiceDataModel
import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel

fun QuestionDataModel.toDomain() = Question(
    id = id,
    choices = choices.map { it.toDomain() },
    question= question
)

fun ChoiceDataModel.toDomain() = Choice(
    choice = choice,
    id = id
)

fun TraitDataModel.toDomain() = Trait(
    id = id,
    name = name
)