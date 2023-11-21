package com.example.data.signUp

import com.example.common.Resource
import com.example.common.remote.BaseRemoteDataSource
import com.example.data.signUp.models.SignUpResponse
import com.example.domin.signUp.ISignUpUser
import kotlinx.coroutines.flow.flowOf

class SignUpRepository(private val signUpApi: SignUpApi) : ISignUpUser, BaseRemoteDataSource() {

    override fun signUp(
        userName: String,
        password: String,
        email: String
    ) = flowOf(
        Resource.Success(
            data = SignUpResponse(
                "ahmed",
                "12345678",
                "ahmed@yahoo.com",
                true
            ).toSignUpDto()
        )
    )

    //    override fun signUp(
    //        userName: String,
    //        password: String,
    //        email: String
    //    ) = safeApiCall {
    //        signUpApi.signUp(SignUpRequest(userName, password, email))
    //    }.map {
    //        when (it) {
    //            is DataResult.Error -> DataResult.Error(it.errorTypes)
    //
    //            is DataResult.Loading -> DataResult.Loading(true)
    //
    //            is DataResult.Success -> DataResult.Success(data = it.data?.toSignUpDto())
    //        }
    //    }
}