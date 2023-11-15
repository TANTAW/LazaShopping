package com.example.data.login

import com.example.common.DataResult
import com.example.domin.login.ILoginUser
import kotlinx.coroutines.flow.flowOf

class LoginRepository : ILoginUser {

    override fun login(userName: String, password: String) =
        flowOf(DataResult.Success(data = LoginResponse(userName, password, true).toLoginDto()))
}