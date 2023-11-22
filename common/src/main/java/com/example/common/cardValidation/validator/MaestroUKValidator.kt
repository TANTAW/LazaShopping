package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * Maestro UK format:
 * length = 12 - 19
 * IIN range = 6759, 676770 - 676774
 */
class MaestroUKValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        if (creditCardNumberList.size in 12..19) {
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
        val innRange = intArrayOf(6759, 676770, 676774)
        val firstFour: Int = parseIIN(creditCardNumberList, 4)
        val firstSix: Int = parseIIN(creditCardNumberList, 6)
        if (firstFour == innRange[0]) {
            hasAllowedIINRange = true
        }
        if (firstSix == innRange[1]) {
            hasAllowedIINRange = true
        }
        if (firstSix == innRange[2]) {
            hasAllowedIINRange = true
        }
        return hasAllowedIINRange
    }
}