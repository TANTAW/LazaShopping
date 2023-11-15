package com.example.domin.forgotPassword

import com.ahmed.a.habib.common.Resource
import kotlinx.coroutines.flow.Flow

class ForgotPasswordUseCase(private val forgotPasswordRepository: IForgotPassword) {
    operator fun invoke(email: String): Flow<Resource<ForgotPasswordDto>> =
        forgotPasswordRepository.forgotPassword(email)
}