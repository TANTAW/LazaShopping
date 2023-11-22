package com.example.common.cardValidation.validator

/*
 * Credit card validator abstract asserting requirements
 * for card type validation and implementing the validate
 * method.
 */
abstract class CreditCardValidator {
    /*
     * Validate if length and IIN ranges match the card
     * type format.
     *
     * @return boolean representing whether or not card
     * card matches the card type requirements.
     */
    fun validate(): Boolean {
        var isValid = false
        val correctLength = checkLength()
        val correctIIN = checkIINRanges()
        if (correctLength && correctIIN) {
            isValid = true
        }
        return isValid
    }

    /*
     * Require check length and IIN range method implementation
     * at the card type validator level.
     */
    abstract fun checkLength(): Boolean
    abstract fun checkIINRanges(): Boolean
}