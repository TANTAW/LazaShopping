package com.example.common.remote


sealed class ErrorTypes(open val errorMessage: String?) {

    class ConnectError(override val errorMessage: String? = "Check your internet connection and try again!") :
        ErrorTypes(errorMessage)

    class AuthenticationError(override val errorMessage: String? = "Auth error happened, please logout and login agan!") :
        ErrorTypes(errorMessage)

    class NoData(override val errorMessage: String? = "No data found!") : ErrorTypes(errorMessage)

    class GeneralError(override val errorMessage: String) : ErrorTypes(errorMessage)

    class NetworkError(override val errorMessage: String) : ErrorTypes(errorMessage)
}