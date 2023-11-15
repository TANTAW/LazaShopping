package com.example.domin.login

import com.ahmed.a.habib.common.DataResult
import kotlinx.coroutines.flow.Flow

interface ILoginUser {
    fun login(
        userName: String,
        password: String,
    ): Flow<DataResult<LoginUserDto>>
}