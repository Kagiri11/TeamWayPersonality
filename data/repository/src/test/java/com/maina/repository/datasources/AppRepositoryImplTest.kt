package com.maina.repository.datasources

import com.google.common.truth.Truth.assertThat
import com.maina.domain.utils.Result
import com.maina.network.api.PersonalityRemoteSource
import com.maina.repository.utils.Data
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class AppRepositoryImplTest {

    // System Under Test
    private lateinit var appRepositoryImpl: AppRepositoryImpl
    private lateinit var remoteSource: PersonalityRemoteSource

    @Before
    fun setup(){
        remoteSource = mockk()
        appRepositoryImpl = AppRepositoryImpl(remoteSource = remoteSource)
    }

    @Test
    fun `getQuestions returns a list of questions on succesful api response`() = runTest{
        coEvery { remoteSource.fetchQuestions() } returns Response.success(listOf(Data.questionDataModel))

        val result = appRepositoryImpl.getQuestions()

        assertThat((result as Result.Success).data.size).isEqualTo(1)
    }

    @Test
    fun `complete Trait returns a trait on succesful api response`() = runTest{
        coEvery { remoteSource.fetchTraits() } returns Response.success(listOf(Data.traitDataModel))

        val result = appRepositoryImpl.completeTest()

        assertThat((result as Result.Success).data).isEqualTo(Data.trait)
    }

}