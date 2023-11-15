package com.ahmed.a.habib.data.login

import retrofit2.Response
import retrofit2.http.GET

interface LoginApi {

    @GET
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
}