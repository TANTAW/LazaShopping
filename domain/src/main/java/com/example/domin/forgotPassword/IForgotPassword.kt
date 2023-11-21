package com.example.domin.forgotPassword

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface IForgotPassword {
    fun forgotPassword(email: String): Flow<Resource<ForgotPasswordDto>>
}