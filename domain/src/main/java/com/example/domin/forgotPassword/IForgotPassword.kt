package com.example.domin.forgotPassword

import com.ahmed.a.habib.common.DataResult
import kotlinx.coroutines.flow.Flow

interface IForgotPassword {
    fun forgotPassword(email: String): Flow<DataResult<ForgotPasswordDto>>
}