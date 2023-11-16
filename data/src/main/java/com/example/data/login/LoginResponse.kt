package com.example.data.login

import com.example.domin.login.LoginUserDto


data class LoginResponse(
    val userName: String,
    val password: String,
    val status: Boolean
) {
    fun toLoginDto() = LoginUserDto(userName, password)
}