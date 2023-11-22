package com.example.common.cardValidation.utils

import com.example.common.cardValidation.utils.DateFormatter.monthFormat
import com.example.common.cardValidation.utils.DateFormatter.yearFormat
import java.util.Calendar

/*
* Date checker used to validate expiration date against
* current year and month
*/
object DateChecker {
    /*
     * Set the current year and month for comparison values
     */
    val CURRENT_YEAR = currentYear
    val CURRENT_MONTH = currentMonth

    /*
     * @param accept expiration month/year, compare against
     * current month/year
     * @return boolean representing whether or not the card
     * s expired
     */
    fun compareDates(date: Int, currentDate: Int): Boolean {
        var isValid = false
        if (date > currentDate) {
            isValid = true
        }
        return isValid
    }

    /*
     * @param String representation of the expirationDate
     * @return expirationDate as a StringBuilder
     */
    fun convertDate(expirationDate: String?): StringBuilder {
        return StringBuilder(expirationDate)
    }

    private val currentYear: Int
        /*
     * @return the current year
     */private get() = yearFormat().format(Calendar.getInstance().time).toInt()
    private val currentMonth: Int
        /*
     * @return the current month
     */private get() = monthFormat().format(Calendar.getInstance().time).toInt()
}