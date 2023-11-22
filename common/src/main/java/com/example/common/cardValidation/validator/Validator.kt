package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.DateChecker.CURRENT_MONTH
import com.example.common.cardValidation.utils.DateChecker.CURRENT_YEAR
import com.example.common.cardValidation.utils.DateChecker.compareDates
import com.example.common.cardValidation.utils.DateChecker.convertDate
import com.example.common.cardValidation.utils.DateParser

/*
 * Validator used to consume credit card number, expiration
 * date & CVV for validation
 */
class Validator {
    private var creditCardNumber: String
    private var expirationDate: StringBuilder? = null
    private var expirationYear: Int? = null
    private var expirationMonth: Int? = null
    private var CVV: String? = null

    /*
     * @param String representation of credit card number
     */
    constructor(creditCardNumber: String) {
        this.creditCardNumber = creditCardNumber
    }

    /*
     * @param String representation of credit card number,
     * expiration date & CVV
     */
    constructor(creditCardNumber: String, expirationDate: String?, CVV: String?) {
        this.creditCardNumber = creditCardNumber
        this.expirationDate = DateParser.parseDate(convertDate(expirationDate))
        this.CVV = CVV
        setExpirationMonth()
        setExpirationYear()
    }

    /*
     * Set expiration year
     */
    private fun setExpirationYear() {
        expirationYear = DateParser.parseDate(expirationDate!!, 2, 4)
    }

    /*
     * Set expiration month
     */
    private fun setExpirationMonth() {
        expirationMonth = DateParser.parseDate(expirationDate!!, 0, 2)
    }

    /*
     * Validate credit card number using Luhn algorithm
     * @throws InvalidCardException if card does not pass
     * test.
     */
    @Throws(InvalidCardException::class)
    fun validate(): Boolean {
        val luhnValidator = LuhnValidator()
        val isValid = luhnValidator.validate(creditCardNumber)
        if (!isValid) {
            throw InvalidCardException("This card isn't invalid")
        }
        return isValid
    }

    /*
     * @return boolean of whether or not the CVV matches
     * the appropriate length
     */
    fun checkCVV(): Boolean = CVV!!.length == 3 || CVV!!.length == 4

    /*
     * @return boolean of whether or not the card is expired
     */
    fun checkExpirationDate(): Boolean {
        var isValid = false
        if (compareDates(expirationYear!!, CURRENT_YEAR)) {
            isValid = true
        } else if (compareDates(expirationMonth!!, CURRENT_MONTH)) {
            isValid = true
        }
        return isValid
    }
}