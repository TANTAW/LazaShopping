package com.example.data.checkout


import com.example.common.remote.ResponseStatus
import com.example.data.checkout.models.CartRequest
import retrofit2.Response
import retrofit2.http.POST

interface CheckoutApi {

    @POST
    suspend fun checkout(cartRequest: CartRequest): Response<ResponseStatus>
}