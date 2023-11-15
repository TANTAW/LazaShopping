package com.example.domin.forgotPassword

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

class ForgotPasswordUseCase(private val forgotPasswordRepository: IForgotPassword) {
    operator fun invoke(email: String): Flow<DataResult<ForgotPasswordDto>> =
        forgotPasswordRepository.forgotPassword(email)
}