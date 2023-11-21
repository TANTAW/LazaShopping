package com.example.domin.login

import com.example.common.Resource
import com.example.common.TextUI
import com.example.common.remote.ErrorTypes
import com.example.domin.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class LoginUserUseCase(private val loginUser: ILoginUser) {

    operator fun invoke(userName: String, password: String): Flow<Resource<LoginUserDto>> {
        if (userName.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_username))))
        if (password.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_password))))
        if (password.length < 8)
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.more_than_8))))
        if (password.any { it.isDigit() } && password.any { it.isLetter() } && password.any { !it.isUpperCase() })
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.password_validation))))
        return loginUser.login(userName, password)
    }
}
