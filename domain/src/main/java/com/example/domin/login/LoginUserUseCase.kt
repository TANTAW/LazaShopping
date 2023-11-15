package com.example.domin.login

import com.ahmed.a.habib.common.DataResult
import kotlinx.coroutines.flow.Flow

class LoginUserUseCase(private val loginUser: ILoginUser) {

    operator fun invoke(userName: String, password: String): Flow<DataResult<LoginUserDto>> =
        loginUser.login(userName, password)
}