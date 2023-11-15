package com.example.domin.changePassword

import com.example.domin.common.Resource
import kotlinx.coroutines.flow.Flow

class ChangePasswordUseCase(private val changePasswordRepository: IChangePassword) {
    operator fun invoke(newPassword: String): Flow<Resource<ChangePasswordDto>> = changePasswordRepository.changePassword(newPassword)
}