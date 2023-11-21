package com.example.common

import android.content.Context

sealed class TextUI{
    data class DynamicString(val string: String): TextUI()
    data class StringResource(val resourceID: Int): TextUI()

    fun asString(context: Context): String {
        return when(this){
            is DynamicString -> string
            is StringResource -> context.getString(resourceID)
        }
    }
}

