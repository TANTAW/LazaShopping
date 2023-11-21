package com.example.domin.changePassword

import com.example.common.Resource
import com.example.common.TextUI
import com.example.common.remote.ErrorTypes
import com.example.domin.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ChangePasswordUseCase(private val changePassword: IChangePassword) {
    operator fun invoke(password: String, confirmation: String): Flow<Resource<ChangePasswordDto>> {
        if (password.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_password))))
        if (password.length < 8)
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.more_than_8))))
        if (password.any { it.isDigit() } && password.any { it.isLetter() } && password.any { !it.isUpperCase() })
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.password_validation))))
        if (confirmation.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_confirm_password))))
        if (password != confirmation)
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.not_the_same_password))))
        return changePassword.changePassword(password, confirmation)
    }

}