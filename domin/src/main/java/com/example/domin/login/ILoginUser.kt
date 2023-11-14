package com.example.domin.login

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

interface ILoginUser {
    fun login(
        userName: String,
        password: String,
    ): Flow<Resource<LoginUserDto>>
}