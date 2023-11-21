package com.example.laza.signup

import com.example.common.BaseViewModel
import com.example.common.Resource
import com.example.common.SingleMutableLiveData
import com.example.domin.signUp.SignUpUseCase
import kotlinx.coroutines.flow.map

class SignUpViewModel(private val signUpUseCase: SignUpUseCase): BaseViewModel() {
    private val _success: SingleMutableLiveData<Boolean> = SingleMutableLiveData()
    val states get() = _success

    fun signup(username: String, password: String, email: String) {
        signUpUseCase.invoke(username, password, email)
            .map {
                when (it) {
                    is Resource.Error -> {
                        handleError(it.errorTypes)
                    }

                    is Resource.Loading -> handleLoading(true)
                    is Resource.Success -> {
                        handleLoading(false)
                        _success.value = true
                    }
                }
            }
    }
}