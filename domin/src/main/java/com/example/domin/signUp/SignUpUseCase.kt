package com.example.domin.signUp

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(private val signISignUpUserRepository: ISignUpUser) {
    operator fun invoke(
        userName: String,
        password: String,
        email: String,
    ): Flow<Resource<SignUpUserDto>> = signISignUpUserRepository.signUp(userName, password, email)
}