package com.example.common

import com.example.common.remote.ErrorTypes

sealed class DataResult<out T : Any> {
    data class Loading<out T : Any>(val data: Boolean) : DataResult<T>()
    data class Success<out T : Any>(val data: T?) : DataResult<T>()
    data class Error(val errorTypes: ErrorTypes) : DataResult<Nothing>()
}