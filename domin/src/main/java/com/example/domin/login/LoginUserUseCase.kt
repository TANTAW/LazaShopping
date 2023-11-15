package com.example.domin.login

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(private val loginUserRepository: ILoginUser) {
    operator fun invoke(userName: String, password: String): Flow<Resource<LoginUserDto>> =
        loginUserRepository.login(userName, password)
}