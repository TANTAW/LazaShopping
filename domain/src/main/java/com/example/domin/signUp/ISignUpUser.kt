package com.example.domin.signUp

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

interface ISignUpUser {
    fun signUp(
        userName: String,
        password: String,
        email: String,
    ): Flow<DataResult<SignUpUserDto>>
}