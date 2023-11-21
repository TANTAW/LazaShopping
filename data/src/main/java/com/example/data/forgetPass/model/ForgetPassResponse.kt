package com.example.data.forgetPass.model

import com.example.domin.forgotPassword.ForgotPasswordDto

data class ForgetPassResponse(
    val email: String,
    val status: Boolean
) {
    fun toDto() = ForgotPasswordDto(email)
}