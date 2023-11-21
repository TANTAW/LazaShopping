package com.example.data.home


import com.example.data.home.models.BrandsResponse
import retrofit2.Response
import retrofit2.http.GET

interface BrandsApi {

    @GET
    suspend fun getBrands(): Response<List<BrandsResponse>>
}