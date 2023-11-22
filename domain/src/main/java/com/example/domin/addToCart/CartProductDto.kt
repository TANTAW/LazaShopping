package com.example.domin.addToCart

import com.example.domin.home.ProductDto

data class CartProductDto(
    val productDto: ProductDto,
    val productCount: Int = 1
)
