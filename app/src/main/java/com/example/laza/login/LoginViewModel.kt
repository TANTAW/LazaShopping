package com.example.laza.login

import com.example.common.BaseViewModel
import com.example.common.DataResult
import com.example.common.SingleMutableLiveData
import com.example.domin.login.LoginUserUseCase
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class LoginViewModel(private val login: LoginUserUseCase) : BaseViewModel() {

    private val _success: SingleMutableLiveData<Boolean> = SingleMutableLiveData()
    val states get() = _success

    fun login(username: String, password: String) {
        login.invoke(username, password)
            .map {
                when (it) {
                    is DataResult.Error -> {
                        handleError(it.errorTypes)
                    }

                    is DataResult.Loading -> handleLoading(true)
                    is DataResult.Success -> {
                        handleLoading(false)
                        _success.value = true
                    }
                }
            }
    }
}