package com.example.data.login

import com.example.common.Resource
import com.example.common.remote.BaseRemoteDataSource
import com.example.data.login.models.LoginResponse
import com.example.domin.login.ILoginUser
import kotlinx.coroutines.flow.flowOf


class LoginRepository(private val api: LoginApi) : ILoginUser, BaseRemoteDataSource() {

    override fun login(userName: String, password: String) =
        flowOf(Resource.Success(data = LoginResponse(userName, password, true).toLoginDto()))

    //    override fun login(userName: String, password: String) =
    //        safeApiCall { api.login(LoginRequest(userName, password)) }
    //            .map {
    //                when (it) {
    //                    is DataResult.Loading -> DataResult.Loading(data = true)
    //                    is DataResult.Error -> DataResult.Error(errorTypes = it.errorTypes)
    //                    is DataResult.Success -> DataResult.Success(data = it.data?.toLoginDto())
    //                }
    //            }
}