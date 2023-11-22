package com.example.common.cardValidation.validator

import com.example.common.cardValidation.utils.CreditCardParser.parseIIN
import com.example.common.cardValidation.utils.CreditCardParser.parseNumber

/*
 * China T-Union format:
 * length = 16
 * IIN range = 31
 */
class ChinaTUnionValidator(creditCardNumber: String?) : CreditCardValidator() {
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
        if (creditCardNumberList.size == 19) {
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
        val innRange = 31
        val firstTwo: Int = parseIIN(creditCardNumberList, 2)
        if (firstTwo == innRange) {
            hasAllowedIINRange = true
        }
        return hasAllowedIINRange
    }
}