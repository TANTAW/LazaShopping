package com.example.common.cardValidation.utils

import java.text.DateFormat
import java.text.SimpleDateFormat

/*
* Date formatter used by the DateChecker to parse month && year
* out of the expiration date
*/
internal object DateFormatter {
    /*
     * @return a year SimpleDateFormat
     */
    fun yearFormat(): DateFormat {
        return SimpleDateFormat("yy")
    }

    /*
     * @return a month SimpleDateFormat
     */
    fun monthFormat(): DateFormat {
        return SimpleDateFormat("MM")
    }
}