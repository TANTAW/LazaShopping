package com.example.data.forgetPass

import com.example.common.Resource
import com.example.common.remote.BaseRemoteDataSource
import com.example.data.forgetPass.model.ForgetPassResponse
import com.example.domin.forgotPassword.IForgotPassword
import kotlinx.coroutines.flow.flowOf


class ForgetPassRepository(private val forgetPassApi: ForgetPassApi) : IForgotPassword, BaseRemoteDataSource() {

    override fun forgotPassword(email: String) =
        flowOf(Resource.Success(ForgetPassResponse(email, true).toDto()))

    //    override fun forgotPassword(email: String) = safeApiCall {
    //        forgetPassApi.forgetPass(ForgetPassRequest(email))
    //    }.map {
    //        when (it) {
    //            is DataResult.Loading -> DataResult.Loading(data = true)
    //            is DataResult.Error -> DataResult.Error(errorTypes = it.errorTypes)
    //            is DataResult.Success -> DataResult.Success(data = it.data?.toDto())
    //        }
    //    }
}