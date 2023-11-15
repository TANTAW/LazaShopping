package com.example.domin.forgotPassword

import com.ahmed.a.habib.common.Resource
import kotlinx.coroutines.flow.Flow

class ForgotPasswordUseCase(private val forgotPassword: IForgotPassword) {
    operator fun invoke(email: String): Flow<Resource<ForgotPasswordDto>> =
        forgotPassword.forgotPassword(email)
}