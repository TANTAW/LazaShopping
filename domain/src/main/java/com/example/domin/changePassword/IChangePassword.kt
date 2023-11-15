package com.example.domin.changePassword

import com.example.common.DataResult
import kotlinx.coroutines.flow.Flow

interface IChangePassword {
    fun changePassword(newPassword: String): Flow<DataResult<ChangePasswordDto>>
}