package com.ahmed.a.habib.common

import com.ahmed.a.habib.common.remote.ErrorTypes

sealed class DataResult<out T : Any> {
    data class Loading<out T : Any>(val data: T?) : DataResult<T>()
    data class Success<out T : Any>(val data: T?) : DataResult<T>()
    data class Error(val errorTypes: ErrorTypes) : DataResult<Nothing>()
}
