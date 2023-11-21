package com.example.data.home.models

import com.example.domin.home.ProductDto
import com.example.domin.home.ReviewDto


data class ProductModel(
    val title: String,
    val price: Double,
    val sizeList: List<String>,
    val description: String,
    val fullImage: String,
    val smallImageList: List<String>,
    val totalReview: Double,
    val reviews: List<ReviewModel>
) {
    fun toProductDto() = ProductDto(
        title,
        price,
        sizeList,
        description,
        fullImage,
        smallImageList,
        totalReview,
        getListOfReviewAsDto(reviews)
    )

    private fun getListOfReviewAsDto(reviews: List<ReviewModel>): List<ReviewDto> {
        val reviewDto: ArrayList<ReviewDto> = ArrayList()

        reviews.forEach {
            reviewDto.add(it.toReviewDto())
        }

        return reviewDto.toList()
    }
}