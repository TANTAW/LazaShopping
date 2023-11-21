package com.example.data.signUp


import com.example.data.signUp.models.SignUpRequest
import com.example.data.signUp.models.SignUpResponse
import retrofit2.Response
import retrofit2.http.POST

interface SignUpApi {

    @POST
    suspend fun signUp(signUpRequest: SignUpRequest): Response<SignUpResponse>
}