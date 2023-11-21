package com.example.common.remote

import com.example.common.TextUI


sealed class ErrorTypes(open val errorMessage: TextUI) {

    class ConnectError(override val errorMessage: TextUI = TextUI.DynamicString("Check your internet connection and try again!")) :
        ErrorTypes(errorMessage)

    class AuthenticationError(override val errorMessage: TextUI = TextUI.DynamicString("Auth error happened, please logout and login agan!")) :
        ErrorTypes(errorMessage)

    class NoData(override val errorMessage: TextUI = TextUI.DynamicString("No data found!")) : ErrorTypes(errorMessage)

    class GeneralError(override val errorMessage: TextUI) : ErrorTypes(errorMessage)

    class NetworkError(override val errorMessage: TextUI) : ErrorTypes(errorMessage)


}