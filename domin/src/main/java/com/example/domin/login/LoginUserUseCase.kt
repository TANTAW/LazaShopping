package com.example.domin.login

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(private val loginUser: ILoginUser) {
    operator fun invoke(userName: String, password: String): Flow<Resource<LoginUserDto>> =
        loginUser.login(userName, password)
}