package com.example.data.forgetPass

import com.example.data.forgetPass.model.ForgetPassRequest
import com.example.data.forgetPass.model.ForgetPassResponse
import retrofit2.Response
import retrofit2.http.GET

interface ForgetPassApi {

    @GET
    suspend fun forgetPass(forgetPassRequest: ForgetPassRequest): Response<ForgetPassResponse>
}