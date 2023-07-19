package com.maina.repository.datasources

import com.maina.domain.repository.AppRepository
import com.maina.network.api.PersonalityRemoteSource

class AppRepositoryImpl(private val remoteSource: PersonalityRemoteSource): AppRepository {
}