package com.example.domin.addReview

import com.example.common.DataResult
import com.example.domin.home.ReviewDto
import kotlinx.coroutines.flow.Flow

class AddReviewUseCase(private val addReview: IAddReview) {
    operator fun invoke(
        name: String,
        date: String,
        rate: Double,
        description: String,
    ): Flow<DataResult<ReviewDto>> = addReview.addReview(name, date, rate, description)
}