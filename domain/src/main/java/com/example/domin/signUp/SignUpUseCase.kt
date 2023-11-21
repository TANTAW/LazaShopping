package com.example.domin.signUp

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(private val signISignUpUser: ISignUpUser) {

    operator fun invoke(
        userName: String,
        password: String,
        email: String,
    ): Flow<Resource<SignUpUserDto>> = signISignUpUser.signUp(userName, password, email)
}