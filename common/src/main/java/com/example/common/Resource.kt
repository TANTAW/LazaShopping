package com.example.common

import com.example.common.remote.ErrorTypes

sealed class Resource<out T : Any> {
    data class Loading<out T : Any>(val data: Boolean) : Resource<T>()
    data class Success<out T : Any>(val data: T?) : Resource<T>()
    data class Error(val errorTypes: ErrorTypes) : Resource<Nothing>()
}