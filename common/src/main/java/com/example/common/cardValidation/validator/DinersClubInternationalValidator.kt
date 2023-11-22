package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * Diners Club International format:
 * length = 16 - 19
 * IIN range = 300 - 305, 3095, 38 - 39
 */
class DinersClubInternationalValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        if (creditCardNumberList.size in 16..19) {
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
        val innRange = intArrayOf(300, 305, 3095, 38, 39)
        val firstTwo: Int = parseIIN(creditCardNumberList, 2)
        val firstThree: Int = parseIIN(creditCardNumberList, 3)
        val firstFour: Int = parseIIN(creditCardNumberList, 4)
        for (i in innRange[0]..innRange[1]) {
            if (firstThree == i) {
                hasAllowedIINRange = true
                break
            }
        }
        if (!hasAllowedIINRange) {
            if (firstFour == innRange[2]) {
                hasAllowedIINRange = true
            }
        }
        if (!hasAllowedIINRange) {
            for (i in innRange[3]..innRange[4]) {
                if (firstTwo == i) {
                    hasAllowedIINRange = true
                    break
                }
            }
        }
        return hasAllowedIINRange
    }
}