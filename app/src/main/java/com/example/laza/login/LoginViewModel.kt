package com.example.laza.login

import com.example.common.BaseViewModel
import com.example.common.Resource
import com.example.common.SingleMutableLiveData
import com.example.domin.login.LoginUserUseCase
import kotlinx.coroutines.flow.map

class LoginViewModel(private val login: LoginUserUseCase) : BaseViewModel() {

    private val _success: SingleMutableLiveData<Boolean> = SingleMutableLiveData()
    val states get() = _success

    fun login(username: String, password: String) {
        login.invoke(username, password)
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