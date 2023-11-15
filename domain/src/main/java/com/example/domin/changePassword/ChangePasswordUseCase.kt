package com.example.domin.changePassword

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

class ChangePasswordUseCase(private val changePassword: IChangePassword) {
    operator fun invoke(newPassword: String): Flow<DataResult<ChangePasswordDto>> =
        changePassword.changePassword(newPassword)
}