package com.maina.repository.mappers

import com.google.common.truth.Truth
import com.maina.domain.models.Choice
import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.network.models.ChoiceDataModel
import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel
import org.junit.Test

class DataModelToDomainTest {

    // Utilities
    private val choiceDataModel = ChoiceDataModel(choice = "Choice One", id = "123")
    private val choice = Choice(choice = "Choice One", id = "123")
    private val traitDataModel = TraitDataModel(id = "Trait One", name = "Extroverted")
    private val trait = Trait(id = "Trait One", name = "Extroverted")
    private val questionDataModel =
        QuestionDataModel(choices = listOf(choiceDataModel), id = 1, question = "Question One")
    private val question = Question(choices = listOf(choice), id = 1, question = "Question One")

    @Test
    fun `choice datamodel toDomain returns the correct choice structure`() {
        Truth.assertThat(choiceDataModel.toDomain()).isEqualTo(choice)
    }

    @Test
    fun `trait datamodel toDomain returns the correct trait structure`() {
        Truth.assertThat(traitDataModel.toDomain()).isEqualTo(trait)
    }

    @Test
    fun `question datamodel toDomain returns the correct question structure`() {
        Truth.assertThat(questionDataModel.toDomain()).isEqualTo(question)
    }
}