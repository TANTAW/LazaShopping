package com.example.domin.login

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(private val loginUser: ILoginUser) {

    operator fun invoke(userName: String, password: String): Flow<Resource<LoginUserDto>> {
        return loginUser.login(userName, password)
    }
}
