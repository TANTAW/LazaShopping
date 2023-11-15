package com.example.common.remote

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.Response

open class BaseRemoteDataSource {

    fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>
    ): Flow<DataResult<T>> =
        flow {
            emit(safeApiResult(call))
        }

    private suspend fun <T : Any> safeApiResult(call: suspend () -> Response<T>): DataResult<T> {
        var response: Response<T>? = null

        try {
            response = call.invoke()
        } catch (ex: Exception) {
            ex.printStackTrace()
            return getResultError(response)
        }

        if (response.isSuccessful) {
            return DataResult.Success(response.body())
        }

        return getResultError(response)
    }

    private fun <T> getResultError(response: Response<T>?): DataResult.Error {
        return when (response?.code()) {

            401 -> {
                DataResult.Error(ErrorTypes.AuthenticationError())
            }

            in 402..499 -> {
                val message: String = try {
                    val jObjError = JSONObject(response?.errorBody()?.string().orEmpty())
                    jObjError.getString("message").orEmpty()
                } catch (e: Exception) {
                    "Error happened, try again."
                }

                DataResult.Error(
                    ErrorTypes.NetworkError(
                        message
                    )
                )
            }

            500 -> {
                DataResult.Error(
                    ErrorTypes.NetworkError("Opps, unknown error happened, please try again later")
                )
            }

            else -> {
                DataResult.Error(
                    ErrorTypes.GeneralError(
                        response?.errorBody()?.string().orEmpty()
                    )
                )
            }
        }
    }
}
