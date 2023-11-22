package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * American Express format:
 * length = 15
 * IIN range = 34 - 37
 */
class AmericanExpressValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        if (creditCardNumberList.size == 15) {
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
        val innRange = intArrayOf(34, 37)
        val inn: Int = parseIIN(creditCardNumberList, 2)
        for (i in innRange[0]..innRange[1]) {
            if (inn == i) {
                hasAllowedIINRange = true
                break
            }
        }
        return hasAllowedIINRange
    }
}