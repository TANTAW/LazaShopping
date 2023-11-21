package com.example.domin.signUp

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface ISignUpUser {
    fun signUp(
        userName: String,
        password: String,
        email: String,
    ): Flow<Resource<SignUpUserDto>>
}