package com.maina.repository.utils

sealed class NetworkResult<out T : Any> {
    data class Error(val errorDetails: String) : NetworkResult<Nothing>()
    data class Success<out T : Any>(val data: T) : NetworkResult<T>()
}