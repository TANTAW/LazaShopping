package com.example.domin.addReview

import com.example.domin.common.Resource
import com.example.domin.home.ReviewDto
import kotlinx.coroutines.flow.Flow

interface IAddReview {
    fun addReview(name: String, date: String, rate: Double, description: String): Flow<Resource<ReviewDto>>
}