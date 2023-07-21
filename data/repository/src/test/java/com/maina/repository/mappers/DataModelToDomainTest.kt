package com.maina.repository.mappers

import com.google.common.truth.Truth
import com.maina.domain.models.Choice
import com.maina.domain.models.Question
import com.maina.domain.models.Trait
import com.maina.network.models.ChoiceDataModel
import com.maina.network.models.QuestionDataModel
import com.maina.network.models.TraitDataModel
import com.maina.repository.utils.Data
import org.junit.Test

class DataModelToDomainTest {

    @Test
    fun `choice datamodel toDomain returns the correct choice structure`() {
        Truth.assertThat(Data.choiceDataModel.toDomain()).isEqualTo(Data.choice)
    }

    @Test
    fun `trait datamodel toDomain returns the correct trait structure`() {
        Truth.assertThat(Data.traitDataModel.toDomain()).isEqualTo(Data.trait)
    }

    @Test
    fun `question datamodel toDomain returns the correct question structure`() {
        Truth.assertThat(Data.questionDataModel.toDomain()).isEqualTo(Data.question)
    }
}