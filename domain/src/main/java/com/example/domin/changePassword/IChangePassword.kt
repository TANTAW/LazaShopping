package com.example.domin.changePassword

import com.example.common.Resource
import kotlinx.coroutines.flow.Flow

interface IChangePassword {
    fun changePassword(newPassword: String, confirmation: String): Flow<Resource<ChangePasswordDto>>
}