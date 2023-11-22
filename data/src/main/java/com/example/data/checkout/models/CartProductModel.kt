package com.example.data.checkout.models

import com.example.data.home.models.ProductModel

data class CartProductModel(
    val productDto: ProductModel,
    val productCount: Int = 1
)