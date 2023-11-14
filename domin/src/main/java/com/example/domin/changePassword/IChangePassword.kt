package com.example.domin.changePassword

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

interface IChangePassword {
    fun changePassword(newPassword: String): Flow<Resource<ChangePasswordDto>>
}