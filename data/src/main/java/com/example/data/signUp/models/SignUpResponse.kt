package com.example.data.signUp.models

import com.example.domin.signUp.SignUpUserDto

data class SignUpResponse(
    val userName: String,
    val password: String,
    val email: String,
    val status: Boolean
) {
    fun toSignUpDto() = SignUpUserDto(userName, password, email)
}