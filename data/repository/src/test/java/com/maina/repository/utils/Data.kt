package com.maina.repository.utils

import com.maina.domain.models.Choice
import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.network.models.ChoiceDataModel
import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel

object Data {

    val choiceDataModel = ChoiceDataModel(choice = "Choice One", id = "123")
    val choice = Choice(choice = "Choice One", id = "123")
    val traitDataModel = TraitDataModel(id = "Trait One", name = "Extroverted")
    val trait = Trait(id = "Trait One", name = "Extroverted")
    val questionDataModel = QuestionDataModel(choices = listOf(choiceDataModel), id = 1, question = "Question One")
    val question = Question(choices = listOf(choice), id = 1, question = "Question One")

}