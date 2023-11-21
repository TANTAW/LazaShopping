package com.example.data.home.models

import com.example.domin.home.ReviewDto

data class ReviewModel(
    val name: String,
    val date: String,
    val rate: Double,
    val description: String
) {
    fun toReviewDto() = ReviewDto(name, date, rate, description)
}