package com.example.data.login

import com.example.common.Resource
import com.example.common.remote.BaseRemoteDataSource
import com.example.data.login.models.LoginResponse
import com.example.domin.login.ILoginUser
import kotlinx.coroutines.flow.flowOf


class LoginRepository(private val api: LoginApi) : ILoginUser, BaseRemoteDataSource() {

    override fun login(userName: String, password: String) =
        flowOf(Resource.Success(data = LoginResponse(userName, password, true).toLoginDto()))
}