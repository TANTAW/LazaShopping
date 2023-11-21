package com.example.data.home.models

import com.example.domin.home.BrandDto
import com.example.domin.home.ProductDto


data class BrandsResponse(
    val name: String,
    val image: String,
    val productList: List<ProductModel>
) {
    fun toProductDto() = BrandDto(name, image, getProductsAsDto(productList))

    private fun getProductsAsDto(productList: List<ProductModel>): List<ProductDto> {
        val dtoList: ArrayList<ProductDto> = ArrayList()

        productList.forEach {
            dtoList.add(it.toProductDto())
        }

        return dtoList.toList()
    }
}
