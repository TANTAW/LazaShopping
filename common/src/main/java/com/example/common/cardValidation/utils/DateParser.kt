package com.example.common.cardValidation.utils

/*
* Date parser used to standardize date format for
* date comparison
*/
object DateParser {
    /*
     * @param StringBuilder representation of the expiration date
     * @return expiration date StringBuilder without a backslash
     */
    fun parseDate(expirationDate: StringBuilder): StringBuilder {
        if (expirationDate.toString().contains("/")) {
            expirationDate.deleteCharAt(expirationDate.indexOf("/"))
        }
        return expirationDate
    }

    /*
     * @param a StringBuilder representation of the expiration date,
     * start & end location to be parsed
     * @return the parsed date
     */
    fun parseDate(
        expirationDate: StringBuilder,
        startLocation: Int,
        endLocation: Int
    ): Int {
        return expirationDate.substring(startLocation, endLocation).toInt()
    }
}