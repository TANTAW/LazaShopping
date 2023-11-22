package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber


/*
 * Visa Electron format:
 * length = 16
 * IIN range = 417500, 4026 - 4405, 4508 - 4844, 4913 - 4917
 */
class VisaElectronValidator(creditCardNumber: String?) : CreditCardValidator() {
    private val creditCardNumberList: List<Int>

    /*
     * @param String representation of credit card number
     */
    init {
        creditCardNumberList = parseNumber(creditCardNumber!!)
    }

    /*
     * Check the length of the card against the format
     * requirement.
     *
     * @return boolean of whether or not credit card
     * number meet requirement.
     */
    public override fun checkLength(): Boolean {
        var hasAllowedLength = false
        if (creditCardNumberList.size == 16) {
            hasAllowedLength = true
        }
        return hasAllowedLength
    }

    /*
     * Check that IIN meets IIN range requirement
     *
     * @return boolean of whether or not IIN matches
     * requirement
     */
    public override fun checkIINRanges(): Boolean {
        var hasAllowedIINRange = false
        val IINRange = intArrayOf(417500, 4026, 4405, 4508, 4844, 4913, 4917)
        val firstFour: Int = parseIIN(creditCardNumberList, 4)
        val firstFive: Int = parseIIN(creditCardNumberList, 5)
        for (number in IINRange) {
            if (number == firstFour || number == firstFive) {
                hasAllowedIINRange = true
            }
        }
        return hasAllowedIINRange
    }
}