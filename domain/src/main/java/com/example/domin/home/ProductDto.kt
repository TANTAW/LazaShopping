package com.example.domin.home

data class ProductDto(
    val title: String,
    val price: Double,
    val sizeList: List<String>,
    val description: String,
    val fullImage: String,
    val smallImageList: List<String>,
    val totalReview: Double,
    val reviews: List<ReviewDto>
)