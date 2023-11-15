package com.example.domin.addReview

import com.ahmed.a.habib.common.DataResult
import com.example.domin.home.ReviewDto
import kotlinx.coroutines.flow.Flow

interface IAddReview {
    fun addReview(name: String, date: String, rate: Double, description: String): Flow<DataResult<ReviewDto>>
}