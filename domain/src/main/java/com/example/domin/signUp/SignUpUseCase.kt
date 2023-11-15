package com.example.domin.signUp

import com.ahmed.a.habib.common.DataResult
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(private val signISignUpUser: ISignUpUser) {
    operator fun invoke(
        userName: String,
        password: String,
        email: String,
    ): Flow<DataResult<SignUpUserDto>> = signISignUpUser.signUp(userName, password, email)
}