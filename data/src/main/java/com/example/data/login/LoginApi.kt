package com.example.data.login

import com.example.data.login.models.LoginRequest
import com.example.data.login.models.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginApi {

    @GET
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
}