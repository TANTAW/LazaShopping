package com.example.data.home

import com.example.common.Resource
import com.example.common.remote.BaseRemoteDataSource
import com.example.data.home.models.BrandsResponse
import com.example.data.home.models.ProductModel
import com.example.data.home.models.ReviewModel
import com.example.domin.home.BrandDto
import com.example.domin.home.IBrandList
import kotlinx.coroutines.flow.flowOf

class BrandsRepository(private val brandsApi: BrandsApi) : IBrandList, BaseRemoteDataSource() {

    private val productOne = ProductModel(
        title = "Polo",
        price = 50.5,
        sizeList = listOf("M", "L", "XL", "XXL"),
        description = "Good product",
        fullImage = "url",
        smallImageList = listOf("", "", "", ""),
        totalReview = 24.6,
        reviews = listOf(ReviewModel("", "", 24.3, "Good product")),
    ).toProductDto()

    private val productTwo = ProductModel(
        title = "Polo",
        price = 50.5,
        sizeList = listOf("M", "L", "XL", "XXL"),
        description = "Good product",
        fullImage = "url",
        smallImageList = listOf("", "", "", ""),
        totalReview = 24.6,
        reviews = listOf(ReviewModel("", "", 24.3, "Good product")),
    ).toProductDto()

    override fun getBrandList() = flowOf(
        Resource.Success(
            data = listOf(BrandDto("Nike", "nike_logo.com", listOf(productOne, productTwo)))
        )
    )

    //    override fun getBrandList() = safeApiCall {
    //        brandsApi.getBrands()
    //    }.map {
    //        when (it) {
    //            is DataResult.Loading -> DataResult.Loading(data = true)
    //            is DataResult.Error -> DataResult.Error(errorTypes = it.errorTypes)
    //            is DataResult.Success -> DataResult.Success(data = getBrandsAsDto(it.data))
    //        }
    //    }

    private fun getBrandsAsDto(data: List<BrandsResponse>?): List<BrandDto> {
        val brandsDtoList: ArrayList<BrandDto> = ArrayList()

        data?.forEach {
            brandsDtoList.add(it.toProductDto())
        }

        return brandsDtoList.toList()
    }
}