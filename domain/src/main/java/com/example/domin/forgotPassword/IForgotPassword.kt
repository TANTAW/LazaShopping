package com.example.domin.forgotPassword

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

interface IForgotPassword {
    fun forgotPassword(email: String): Flow<DataResult<ForgotPasswordDto>>
}