package com.example.domin.addReview

import com.example.common.Resource
import com.example.common.TextUI
import com.example.common.remote.ErrorTypes
import com.example.domin.R
import com.example.domin.home.ReviewDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class AddReviewUseCase(private val addReview: IAddReview) {
    operator fun invoke(
        name: String,
        date: String,
        rate: Double,
        description: String,
    ): Flow<Resource<ReviewDto>> {
        if (name.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_username))))
        if (rate <= 0)
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.greater_than_zero))))
        if (description.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_description))))
        return addReview.addReview(name, date, rate, description)
    }
}