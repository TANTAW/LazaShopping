package com.example.domin.forgotPassword

import android.util.Patterns
import com.example.common.Resource
import com.example.common.TextUI
import com.example.common.remote.ErrorTypes
import com.example.domin.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ForgotPasswordUseCase(private val forgotPasswordRepository: IForgotPassword) {
    operator fun invoke(email: String): Flow<Resource<ForgotPasswordDto>> {
        if (email.isBlank())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.empty_email))))
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return flowOf(Resource.Error(ErrorTypes.GeneralError(TextUI.StringResource(R.string.enter_valid_email))))
        return forgotPasswordRepository.forgotPassword(email)
    }

}