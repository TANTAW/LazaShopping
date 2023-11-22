package com.example.common.cardValidation.utils

import com.example.common.cardValidation.CreditCardType
import com.example.common.cardValidation.validator.AmericanExpressValidator
import com.example.common.cardValidation.validator.DiscoverValidator
import com.example.common.cardValidation.validator.MasterCardValidator
import com.example.common.cardValidation.validator.VisaValidator


/*
 * Type checker checking against the most common
 * credit card types: VISA, AMERICAN EXPXRESS,
 * DISCOVER & MASTERCARD.
 */
object TypeChecker {
    /*
     * @param a String representation of the credit card number
     * @return CreditCardType enumerable
     */
    fun checkType(creditCardNumber: String?): CreditCardType? {
        var type: CreditCardType? = null

        // Instantiate credit card validators and set type on match
        while (type == null) {
            var isThisType: Boolean
            val visaValidator = VisaValidator(creditCardNumber)
            isThisType = visaValidator.validate()
            if (isThisType) {
                type = CreditCardType.VISA
                break
            }
            val americanExpressValidator = AmericanExpressValidator(creditCardNumber)
            isThisType = americanExpressValidator.validate()
            if (isThisType) {
                type = CreditCardType.AMERICAN_EXPRESS
                break
            }
            val masterCardValidator = MasterCardValidator(creditCardNumber)
            isThisType = masterCardValidator.validate()
            if (isThisType) {
                type = CreditCardType.MASTERCARD
                break
            }
            val discoverValidator = DiscoverValidator(creditCardNumber)
            isThisType = discoverValidator.validate()
            if (isThisType) {
                type = CreditCardType.DISCOVER
                break
            }

            // If credit card type does not match, mark as "other"
            type = CreditCardType.OTHER
            break
        }
        return type
    }
}